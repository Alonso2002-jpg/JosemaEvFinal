package org.develop.proyectofinal.rest.nota.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.curso.model.Curso;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaRequestDto {
    @NotBlank(message = "El NRC no puede estar vacio")
    @Size(min = 4, max = 4)
    private String nrc;
    @NotBlank(message = "El DNI del Alumno no puede esta vacio")
    @Pattern(regexp = "\\d{8}", message = "El dni debe ser de 8 digitos")
    private String dni;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep1;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep2;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep3;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep4;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer evaParcial;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 1, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer evaFinal;
}
