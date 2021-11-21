package ru.mirea.konnova.questionnaire.model;

import lombok.*;
import javax.persistence.*;


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
}
