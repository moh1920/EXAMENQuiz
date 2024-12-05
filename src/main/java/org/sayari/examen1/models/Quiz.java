package org.sayari.examen1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuiz ;
    private String titreQuiz ;
    private String sepecialite ;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_quiz")
    private Date dateQuiz ;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.EAGER)
    private List<Question> questions ;

    @ManyToMany(mappedBy = "quiz")
    private List<Candidat> candidats;


}
