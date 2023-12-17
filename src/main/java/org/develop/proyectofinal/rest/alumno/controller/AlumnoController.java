package org.develop.proyectofinal.rest.alumno.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.alumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.version}/alumno")
public class AlumnoController {
    private AlumnoService alumnoService;
    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> findAll() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Alumno> save(@Valid @RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
