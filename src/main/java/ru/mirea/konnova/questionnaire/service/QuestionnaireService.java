package ru.mirea.konnova.questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.konnova.questionnaire.dao.AnswerDAO;
import ru.mirea.konnova.questionnaire.dao.QuestionDAO;
import ru.mirea.konnova.questionnaire.dao.QuestionnaireDAO;
import ru.mirea.konnova.questionnaire.dto.AnswerDTO;
import ru.mirea.konnova.questionnaire.model.Answer;
import ru.mirea.konnova.questionnaire.model.Question;
import ru.mirea.konnova.questionnaire.model.User;

import java.util.List;


@Service
public class QuestionnaireService {
    private final QuestionnaireDAO questionnaireDAO;
    private final AnswerDAO answerDAO;
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionnaireService(QuestionnaireDAO questionnaireDAO, AnswerDAO answerDAO, QuestionDAO questionDAO) {
        this.questionnaireDAO = questionnaireDAO;
        this.answerDAO = answerDAO;
        this.questionDAO = questionDAO;
    }

    public void addAnswer(@ModelAttribute AnswerDTO answerDTO, User user, Model model){
        model.addAttribute("questionDTO", answerDTO.getQuestionId());
        model.addAttribute("description", answerDTO.getDescription());

        Answer answer=new Answer();
        answer.setDescription(answerDTO.getDescription());
        answer.setQuestion(questionDAO.findById(answerDTO.getQuestionId()));
        answer.setUser(user);

        answerDAO.save(answer);

    }


//    public void addAnswers(@ModelAttribute Answers answers,  User user, Model model) {
//        model.addAttribute("answers", answers);
//
//
//    }
}
