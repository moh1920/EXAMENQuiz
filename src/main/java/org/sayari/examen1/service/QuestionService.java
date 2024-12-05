package org.sayari.examen1.service;

import org.sayari.examen1.models.Question;
import org.sayari.examen1.models.Quiz;
import org.sayari.examen1.models.Response;
import org.sayari.examen1.reposetry.QuestionRepo;
import org.sayari.examen1.reposetry.QuizRepo;
import org.sayari.examen1.reposetry.ReponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private ReponseRepo reponseRepo ;
    @Autowired
    private QuizRepo quizRepo ;

    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) {
        questionRepo.save(question);
        for (Response response : question.getResponses()){
            reponseRepo.save(response);
        }
        Quiz quiz = quizRepo.findById(idQuiz).orElse(null);
        quiz.getQuestions().add(question);
        return question ;
    }

}
