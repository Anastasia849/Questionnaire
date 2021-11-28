package ru.mirea.konnova.questionnaire.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "question_id")
    private Set<Answer> answerSet;

    @ManyToOne(fetch = FetchType.EAGER)
    Questionnaire questionnaire;
}
