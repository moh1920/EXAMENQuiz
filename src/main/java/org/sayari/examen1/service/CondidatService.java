package org.sayari.examen1.service;

import org.sayari.examen1.models.Candidat;
import org.sayari.examen1.models.Niveau;
import org.sayari.examen1.models.Quiz;
import org.sayari.examen1.reposetry.CondidatRepo;
import org.sayari.examen1.reposetry.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CondidatService {
    @Autowired
    private CondidatRepo condidatRepo ;
    @Autowired
    private QuizRepo quizRepo ;

    public Candidat ajouterCandidat(Candidat candidat){
      return condidatRepo.save(candidat);
    }
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat candidat = condidatRepo.findById(idCandidat).orElse(null);
        List<Quiz> quizList = quizRepo.findAllByTitreQuiz(titreQuiz);
        for (Quiz quiz : quizList){
            candidat.getQuiz().add(quiz);
            candidat.setNbQuiz(candidat.getNbQuiz()+1);
            condidatRepo.save(candidat);
        }
        return quizList.get(0);
    }
    public List<Candidat> recupererCandidat (String specialite, Niveau niveau) {
        return condidatRepo.findByNiveauAndQuizSepecialiteAndQuizDateQuizAfter(niveau,specialite,LocalDate.now());
    }
}
