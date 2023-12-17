package org.develop.proyectofinal.rest.nota.controller;

import org.develop.proyectofinal.page.PageResponse;
import org.develop.proyectofinal.rest.nota.dto.NotaRequestDto;
import org.develop.proyectofinal.rest.nota.model.NotaCursoAlumno;
import org.develop.proyectofinal.rest.nota.service.NotaAlCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/${api.version}/alumnotas")
public class NotaAlCursoController {
    private NotaAlCursoService notaAlCursoService;
    @Autowired
    public NotaAlCursoController(NotaAlCursoService notaAlCursoService) {
        this.notaAlCursoService = notaAlCursoService;
    }

    @GetMapping
    public ResponseEntity<PageResponse<NotaCursoAlumno>> getAlumnotas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(PageResponse.of(notaAlCursoService.findAll(pageable),sortBy,direction));
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<PageResponse<NotaCursoAlumno>> getAlumnotasByCurso(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction){
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(PageResponse.of(notaAlCursoService.findAllByCurso(id,pageable),sortBy,direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaCursoAlumno> getAlumno(@PathVariable Long id){
        return ResponseEntity.ok(notaAlCursoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotaCursoAlumno> saveAlumno(@RequestBody NotaRequestDto notaCursoAlumno){
        return ResponseEntity.ok(notaAlCursoService.save(notaCursoAlumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable Long id){
        notaAlCursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
