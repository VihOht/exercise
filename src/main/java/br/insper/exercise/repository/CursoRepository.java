package br.insper.exercise.repository;

import br.insper.exercise.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso>  findAllByDeletedFalse();
    List<Curso> findAllByDeletedFalseAndTitleStartingWith(String title);
    Optional<Curso> findByIdAndDeletedFalse(Long id);
}
