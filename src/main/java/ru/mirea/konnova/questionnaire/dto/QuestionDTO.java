package ru.mirea.konnova.questionnaire.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
    int id;
    String description;
    int questionnaireId;
}
