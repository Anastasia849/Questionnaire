package ru.mirea.konnova.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.konnova.questionnaire.dto.AnswerDTO;
import ru.mirea.konnova.questionnaire.model.Answer;
import ru.mirea.konnova.questionnaire.model.Questionnaire;
import ru.mirea.konnova.questionnaire.model.User;
import ru.mirea.konnova.questionnaire.service.AdminService;
import ru.mirea.konnova.questionnaire.service.QuestionnaireService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;
    private final AdminService adminService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService, AdminService adminService) {
        this.questionnaireService = questionnaireService;
        this.adminService = adminService;
    }

    @GetMapping("")
    String getQuestionnaires(Model model) {

        List<Questionnaire> questionnaires = adminService.getQuestionnaires();
        model.addAttribute("questionnaire", questionnaires);
        return "main";
    }



    @GetMapping("/questionnaire/{id}")
    String getQuestionnaire(@PathVariable("id") int id, Model model) {
        model.addAttribute("questionnaire", adminService.getQuestionnaireById(id));
        return "questionnaire";
    }

    @PostMapping("/questionnaire/{questionnaireId}/addAnswer")
    public String addAnswer(@ModelAttribute AnswerDTO answerDTO, @PathVariable("questionnaireId") int questionnaireId, @AuthenticationPrincipal User user, Model model) {
        questionnaireService.addAnswer(answerDTO, user, model);
        return String.format("redirect:/home/questionnaire/%d",questionnaireId);
    }

}
