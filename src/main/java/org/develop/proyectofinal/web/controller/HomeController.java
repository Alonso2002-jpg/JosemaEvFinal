package org.develop.proyectofinal.web.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.develop.proyectofinal.rest.alumno.model.Alumno;
import org.develop.proyectofinal.rest.alumno.service.AlumnoService;
import org.develop.proyectofinal.rest.curso.model.Curso;
import org.develop.proyectofinal.rest.curso.services.CursoService;
import org.develop.proyectofinal.rest.nota.dto.NotaRequestDto;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.develop.proyectofinal.rest.nota.service.NotaAlCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {
    private final NotaAlCursoService notaCursoAlumno;
    private final CursoService cursoService;
    private final AlumnoService alumnoService;

    @Autowired
    public HomeController(NotaAlCursoService notaCursoAlumno, CursoService cursoService, AlumnoService alumnoService) {
        this.notaCursoAlumno = notaCursoAlumno;
        this.cursoService = cursoService;
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public String listNotas(Model model,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size,
                            @RequestParam(defaultValue = "id") String sortBy,
                            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<NotaCursoAlumno> pageNotas = notaCursoAlumno.findAll(pageable);
        model.addAttribute("pageNotas", pageNotas);
        return "index";
    }

    @GetMapping("/curso/create")
    public String createCurso(Model model) {
        model.addAttribute("curso", Curso.builder().build());
        return "form-post-curso";
    }

    @PostMapping("/curso/create")
    public String saveCurso(@Valid @ModelAttribute("curso") Curso curso, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form-post-curso";
        }
        cursoService.save(curso);
        return"redirect:/";
    }

    @GetMapping("/alumno/create")
    public String createAlumno(Model model) {
        model.addAttribute("alumno", Alumno.builder().build());
        return "form-post-alumno";
    }

    @PostMapping("/alumno/create")
    public String saveAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form-post-alumno";
        }
        alumnoService.save(alumno);
        return"redirect:/";
    }

    @GetMapping("/create")
    public String createNota(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        model.addAttribute("alumnos", alumnoService.findAll());
        model.addAttribute("notaReq", NotaRequestDto.builder().build());
        return "form-post-notas";
    }

    @PostMapping("/create")
    public String saveNota(@Valid @ModelAttribute("notaReq") NotaRequestDto notaReq, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            model.addAttribute("cursos", cursoService.findAll());
            model.addAttribute("alumnos", alumnoService.findAll());
            return "form-post-notas";
        }
        notaCursoAlumno.save(notaReq);
        return"redirect:/";
    }
}
