package org.sayari.examen1.reposetry;

import org.sayari.examen1.models.Candidat;
import org.sayari.examen1.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CondidatRepo extends JpaRepository<Candidat,Integer> {
    List<Candidat> findByNiveauAndQuizSepecialiteAndQuizDateQuizAfter(Niveau niveau, String specialite,  LocalDate datequiz);
}
