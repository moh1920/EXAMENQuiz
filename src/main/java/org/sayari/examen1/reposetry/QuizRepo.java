package org.sayari.examen1.reposetry;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.sayari.examen1.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    List<Quiz> findAllByTitreQuiz(String titreQuiz);


}
