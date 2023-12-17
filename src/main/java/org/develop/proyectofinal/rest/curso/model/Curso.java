package org.develop.proyectofinal.rest.curso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "El NRC no puede estar vacio")
    @Size(min = 4, max = 4)
    private String nrc;
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "La descripción no puede estar vacia")
    private String descripcion;

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist //pre(antes de insertar asignar el valor en la fecha de creacion)
    void prePersist(){
        createdAt = LocalDateTime.now();
        isActive = true;
    }

    @PreUpdate //pre(antes de actualizar asignar el valor en la fecha de actualizacion)
    void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

}
