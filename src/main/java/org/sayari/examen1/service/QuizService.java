package org.sayari.examen1.service;

import jdk.dynalink.linker.LinkerServices;
import lombok.extern.slf4j.Slf4j;
import org.sayari.examen1.models.Complexite;
import org.sayari.examen1.models.Quiz;
import org.sayari.examen1.reposetry.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class QuizService {
    @Autowired
    private QuizRepo quizRepo ;
    public Quiz ajouterQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Scheduled(cron = "*/30 * * * * *" )
    public void recupererQuizPlusDifficile() {
        List<Quiz> quizList = quizRepo.findAll();
        HashMap<Quiz,Long> difficiles = new HashMap<Quiz,Long>();
        for(Quiz quiz : quizList){
            difficiles.put(quiz,quiz.getQuestions().stream().filter(q -> q.getComplexite().equals(Complexite.FACILE)).count());
        }


        Optional<Map.Entry<Quiz, Long>> quizLePlusDifficile =
                difficiles.entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue());
        quizLePlusDifficile.ifPresent(
                entry ->log.info(entry.getValue().toString())
        );
    }







}
