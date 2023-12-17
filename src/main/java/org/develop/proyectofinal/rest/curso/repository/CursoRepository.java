package org.develop.proyectofinal.rest.curso.repository;

import org.develop.proyectofinal.rest.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
    Curso findByNrc(String nrc);
}
