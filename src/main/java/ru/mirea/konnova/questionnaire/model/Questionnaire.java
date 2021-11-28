package ru.mirea.konnova.questionnaire.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Question> questionSet;

}
