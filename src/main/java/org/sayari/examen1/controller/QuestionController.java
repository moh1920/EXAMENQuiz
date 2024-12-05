package org.sayari.examen1.controller;

import org.sayari.examen1.models.Question;
import org.sayari.examen1.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/ajouterquestoin")
    public ResponseEntity<?> ajouterQuestEtRepEtAffecterQuestAQuiz(@RequestBody Question question , @RequestParam Integer idQuiz){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(questionService.ajouterQuestEtRepEtAffecterQuestAQuiz(question, idQuiz));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erreur lors de l'ajout de la question et des réponses : " + e.getMessage());
        }
    }
}
