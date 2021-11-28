package ru.mirea.konnova.questionnaire.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.mirea.konnova.questionnaire.dao.QuestionDAO;
import ru.mirea.konnova.questionnaire.dao.QuestionnaireDAO;
import ru.mirea.konnova.questionnaire.dto.QuestionDTO;
import ru.mirea.konnova.questionnaire.model.Question;
import ru.mirea.konnova.questionnaire.model.Questionnaire;

import java.util.List;

@Service
public class AdminService {
    private final QuestionnaireDAO questionnaireDAO;
    private final QuestionDAO questionDAO;

    @Autowired
    public AdminService(QuestionnaireDAO questionnaireDAO, QuestionDAO questionDAO) {
        this.questionnaireDAO = questionnaireDAO;
        this.questionDAO = questionDAO;
    }

    public String addQuestionnaire(Questionnaire questionnaire, Errors errors, RedirectAttributes redirectAttributes){
        boolean flagOfErrors = false;
        if(errors.hasErrors()){
            flagOfErrors = true;

            redirectAttributes.addFlashAttribute("name", questionnaire.getName());
            redirectAttributes.addFlashAttribute("description", questionnaire.getDescription());

            List<FieldError> list = errors.getFieldErrors();
            for (FieldError f : list) {
                redirectAttributes.addFlashAttribute(f.getField(), f.getDefaultMessage());
            }
        }

        if(questionnaireDAO.findByName(questionnaire.getName()) != null) {
            flagOfErrors = true;
            redirectAttributes.addFlashAttribute("exists", "Опрос с таким названием уже существует");
        }



        if (!flagOfErrors)
            questionnaireDAO.save(questionnaire);


        return "redirect:/admin";
    }
    
    public String addQuestion(QuestionDTO questionDTO,  Errors errors, RedirectAttributes redirectAttribute){


        boolean flagOfErrors = false;
        if(errors.hasErrors()){
            flagOfErrors = true;

            redirectAttribute.addFlashAttribute("questionnaireId", questionDTO.getQuestionnaireId());
            redirectAttribute.addFlashAttribute("description", questionDTO.getDescription());

            List<FieldError> list = errors.getFieldErrors();
            for (FieldError f : list) {
                redirectAttribute.addFlashAttribute(f.getField(), f.getDefaultMessage());
            }
        }

        if (!flagOfErrors) {
            Question question = new Question();
            question.setDescription(questionDTO.getDescription());
            question.setQuestionnaire(questionnaireDAO.findById(questionDTO.getQuestionnaireId()));

            questionDAO.save(question);
        }
        return "redirect:/admin";
    }

//    public void addQuestion(QuestionDTO questionDTO){
//
//            Question question = new Question();
//            question.setDescription(questionDTO.getDescription());
//            question.setQuestionnaire(questionnaireDAO.getById(questionDTO.getQuestionnaireId()));
//
//            questionDAO.save(question);
//
//    }

    public void deleteQuestionnaire(int id){
        questionnaireDAO.deleteById(id);
    }


    public void deleteQuestion(int id){
        questionDAO.deleteById(id);
    }

    public List<Questionnaire> getQuestionnaires(){
        return questionnaireDAO.findAll();
    }

    public Questionnaire getQuestionnaireById(int id){
        return questionnaireDAO.findById(id);
    }

//    public List<Question> getQuestionsByQuestionnaire(int id){
//        return questionDAO.findAllByQuestionnaire(questionnaireDAO.findById(id));
//    }

}
