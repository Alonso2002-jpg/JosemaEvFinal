package org.develop.proyectofinal.rest.curso.services;

import org.develop.proyectofinal.rest.curso.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save(Curso curso);
    void delete(Long id);
}
