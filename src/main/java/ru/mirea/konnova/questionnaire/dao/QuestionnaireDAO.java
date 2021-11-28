package ru.mirea.konnova.questionnaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.konnova.questionnaire.model.Questionnaire;

@Repository
public interface QuestionnaireDAO extends JpaRepository<Questionnaire, Integer> {
    Questionnaire findById(int id);
    Questionnaire findByName(String name);
}
