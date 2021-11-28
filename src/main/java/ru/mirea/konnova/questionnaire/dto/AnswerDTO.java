package ru.mirea.konnova.questionnaire.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mirea.konnova.questionnaire.model.Question;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class AnswerDTO {
    private int id;
    private String description;

    private int questionId;

}
