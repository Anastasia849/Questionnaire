package ru.mirea.konnova.questionnaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.konnova.questionnaire.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByName(String name);
}
