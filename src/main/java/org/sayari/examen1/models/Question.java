package org.sayari.examen1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdQuestion ;
    private String libelleQ ;
    @Enumerated(value = EnumType.STRING)
    private Complexite complexite ;

    @OneToMany()
    private List<Response> responses ;

    @JsonIgnore()
    @ManyToOne()
    private Quiz quiz ;



}
