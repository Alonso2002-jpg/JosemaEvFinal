package org.develop.proyectofinal.rest.alumno.service;

import org.develop.proyectofinal.rest.alumno.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();
    Alumno save(Alumno alumno);
    Alumno findById(Long id);
    void delete(Long id);
}
