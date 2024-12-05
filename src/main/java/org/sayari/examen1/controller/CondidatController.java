package org.sayari.examen1.controller;

import org.sayari.examen1.models.Candidat;
import org.sayari.examen1.models.Niveau;
import org.sayari.examen1.service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidat")
public class CondidatController {

    @Autowired
    private CondidatService condidatService ;
    @PostMapping("/ajouter")
    private ResponseEntity<?> addCandidat(@RequestBody Candidat candidat){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(condidatService.ajouterCandidat(candidat));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/affectation")
    private ResponseEntity<?> affecterQuizCandidat(@RequestParam String titreQuiz, @RequestParam Integer idCandidat){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(condidatService.affecterQuizCandidat(titreQuiz, idCandidat));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/recuperer")
    private ResponseEntity<?> recupererCandidat(@RequestParam String specialite, @RequestParam Niveau niveau){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(condidatService.recupererCandidat(specialite,niveau));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
