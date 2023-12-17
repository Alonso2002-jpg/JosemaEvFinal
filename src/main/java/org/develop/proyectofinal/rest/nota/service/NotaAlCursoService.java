package org.develop.proyectofinal.rest.nota.service;

import org.develop.proyectofinal.rest.nota.dto.NotaRequestDto;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotaAlCursoService {
    Page<NotaCursoAlumno> findAll(Pageable pageable);
    Page<NotaCursoAlumno> findAllByCurso(Long id, Pageable pageable);
    NotaCursoAlumno findById(Long id);
    NotaCursoAlumno save(NotaRequestDto notaCursoAlumno);
    void delete(Long id);
}
