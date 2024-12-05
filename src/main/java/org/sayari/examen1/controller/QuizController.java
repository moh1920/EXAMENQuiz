package org.sayari.examen1.controller;

import jakarta.persistence.Entity;
import org.sayari.examen1.models.Quiz;
import org.sayari.examen1.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService ;

    @PostMapping("/addQuiz")
    private ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        try{
            return ResponseEntity.ok(quizService.ajouterQuiz(quiz));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erreur lors de l'ajout du quiz : " + e.getMessage());
        }
    }

}
