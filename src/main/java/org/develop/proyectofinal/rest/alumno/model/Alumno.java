package org.develop.proyectofinal.rest.alumno.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;
    private String nomCompleto;
    @Pattern(regexp = "\\d{8}", message = "El dni debe ser de 8 digitos")
    @NotBlank(message = "El dni no puede estar vacio")
    private String dni;

    private LocalDateTime cretedAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        cretedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        nomCompleto = nombre + " " + apellido;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
        nomCompleto = nombre + " " + apellido;
    }
}
