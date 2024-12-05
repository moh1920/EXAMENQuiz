package org.sayari.examen1.reposetry;

import org.sayari.examen1.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
