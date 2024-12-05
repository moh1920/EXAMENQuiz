package org.sayari.examen1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCondidat ;
    private String nomCondidat ;
    private String prenomCondidat ;
    private Integer nbQuiz ;
    @Enumerated(value = EnumType.STRING)
    private Niveau niveau ;


    @ManyToMany()
    private List<Quiz> quiz ;
}
