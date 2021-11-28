package ru.mirea.konnova.questionnaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.konnova.questionnaire.model.Question;
import ru.mirea.konnova.questionnaire.model.Questionnaire;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    Question findById(int id);
    List<Question> findAllByQuestionnaire(Questionnaire questionnaire);
}
