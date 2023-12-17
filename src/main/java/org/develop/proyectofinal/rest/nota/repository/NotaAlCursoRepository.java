package org.develop.proyectofinal.rest.nota.repository;

import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaAlCursoRepository extends JpaRepository<NotaCursoAlumno, Long> {
    Page<NotaCursoAlumno> findAllByCurso(Curso curso, Pageable pageable);

}
