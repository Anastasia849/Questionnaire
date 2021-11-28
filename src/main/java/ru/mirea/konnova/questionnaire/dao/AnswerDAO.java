package ru.mirea.konnova.questionnaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.konnova.questionnaire.model.Answer;

@Repository
public interface AnswerDAO extends JpaRepository<Answer, Integer> {
}
