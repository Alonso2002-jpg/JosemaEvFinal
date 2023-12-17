package org.develop.proyectofinal.rest.nota.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.curso.model.Curso;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nota_curso_alumno")
public class NotaCursoAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep1;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep2;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep3;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer ep4;
    private Integer promedioEp;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer evaParcial;
    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0, message = "La nota minima es 1")
    @Max(value = 20, message = "La nota maxima es 20")
    private Integer evaFinal;
    private Integer promedioFinal;


    public Integer setPromedioEp(){
        promedioEp = (ep1 + ep2 + ep3 + ep4)/4;
        return promedioEp;
    }
    public Integer setPromedioFinal(){
        promedioFinal = (promedioEp + evaParcial + evaFinal)/3;
        return promedioFinal;
    }
}
