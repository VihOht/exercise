package br.insper.exercise.controller;

import br.insper.exercise.entity.CreateCursoRequest;
import br.insper.exercise.entity.Curso;
import br.insper.exercise.service.CursoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    
    @GetMapping("")
    public List<Curso> listCursos(@RequestParam(required = false, defaultValue = "") String title) {
        return cursoService.listCursos(title);
    }

    @PostMapping("")
    public void createCurso(@RequestBody CreateCursoRequest request) {
        cursoService.createCurso(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
            
}
