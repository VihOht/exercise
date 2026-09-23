package br.insper.exercise.service;

import br.insper.exercise.entity.CreateCursoRequest;
import br.insper.exercise.entity.Curso;
import br.insper.exercise.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public List<Curso> listCursos(String title) {
        if (title.isBlank()) {
            return cursoRepository.findAllByDeletedFalse();
        }
        return cursoRepository.findAllByDeletedFalseAndTitleStartingWith(title);
    }

    public void createCurso(CreateCursoRequest request) {
        Curso curso = new Curso();
        curso.setCredits(request.getCredits());
        curso.setDescription(request.getDescription());
        curso.setTitle(request.getTitle());
        cursoRepository.save(curso);
    }


    public void deleteCurso(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso Not Found"));
        curso.setDeleted(true);
        cursoRepository.save(curso);
    }
}
