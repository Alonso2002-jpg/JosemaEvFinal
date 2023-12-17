package org.develop.proyectofinal.rest.nota.service;

import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.alumno.repository.AlumnoRepository;
import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.curso.repository.CursoRepository;
import org.develop.proyectofinal.rest.nota.dto.NotaRequestDto;
import org.develop.proyectofinal.rest.nota.mapper.NotasMapper;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.develop.proyectofinal.rest.nota.repository.NotaAlCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotaAlCursoServiceImpl implements NotaAlCursoService{
    private NotaAlCursoRepository notaAlCursoRepository;
    private CursoRepository cursoRepository;
    private AlumnoRepository alumnoRepository;
    private NotasMapper notasMapper;
    @Autowired
    public NotaAlCursoServiceImpl(NotaAlCursoRepository notaAlCursoRepository,NotasMapper notasMapper, CursoRepository cursoRepository, AlumnoRepository alumnoRepository) {
        this.notaAlCursoRepository = notaAlCursoRepository;
        this.cursoRepository = cursoRepository;
        this.alumnoRepository = alumnoRepository;
        this.notasMapper = notasMapper;
    }
    @Override
    public Page<NotaCursoAlumno> findAll(Pageable pageable) {
        return notaAlCursoRepository.findAll(pageable);
    }

    @Override
    public Page<NotaCursoAlumno> findAllByCurso(Long id, Pageable pageable) {
        Curso curso = cursoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro el curso"));
        return notaAlCursoRepository.findAllByCurso(curso, pageable);
    }


    @Override
    public NotaCursoAlumno findById(Long id) {
        return notaAlCursoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro la nota"));
    }

    @Override
    public NotaCursoAlumno save(NotaRequestDto notaCursoAlumno) {
        Curso curso = cursoRepository.findByNrc(notaCursoAlumno.getNrc());
        Alumno alumno = alumnoRepository.findByDni(notaCursoAlumno.getDni());
        NotaCursoAlumno notaToSave = notasMapper.toNotas(notaCursoAlumno,curso,alumno);
        notaToSave.setPromedioEp();
        notaToSave.setPromedioFinal();
        return notaAlCursoRepository.save(notaToSave);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        notaAlCursoRepository.deleteById(id);
    }
}
