package org.develop.proyectofinal.rest.nota.mapper;

import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.nota.dto.NotaRequestDto;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.springframework.stereotype.Component;

@Component
public class NotasMapper {

    public NotaCursoAlumno toNotas(NotaRequestDto request, Curso curso, Alumno alumno){
        NotaCursoAlumno notacursoalumno = new NotaCursoAlumno();
        notacursoalumno.setAlumno(alumno);
        notacursoalumno.setCurso(curso);
        notacursoalumno.setEvaFinal(request.getEvaFinal());
        notacursoalumno.setEvaParcial(request.getEvaParcial());
        notacursoalumno.setEp1(request.getEp1());
        notacursoalumno.setEp2(request.getEp2());
        notacursoalumno.setEp3(request.getEp3());
        notacursoalumno.setEp4(request.getEp4());
        return notacursoalumno;
    }
}
