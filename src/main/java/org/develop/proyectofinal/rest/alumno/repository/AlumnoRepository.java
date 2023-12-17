package org.develop.proyectofinal.rest.alumno.repository;

import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Alumno findByDni(String nombre);
}
