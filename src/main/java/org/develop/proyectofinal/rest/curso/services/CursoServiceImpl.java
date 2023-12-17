package org.develop.proyectofinal.rest.curso.services;

import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServiceImpl implements CursoService{
    private CursoRepository cursoRepository;
    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }
    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElseThrow( () -> new RuntimeException("No se encontro el curso"));
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        cursoRepository.deleteById(id);
    }
}
