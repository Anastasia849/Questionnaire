package ru.mirea.konnova.questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.mirea.konnova.questionnaire.model.Questionnaire;
import ru.mirea.konnova.questionnaire.service.AdminService;
import ru.mirea.konnova.questionnaire.dto.QuestionDTO;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/addQuestionnaire")
    public String addQuestionnaire(@ModelAttribute @Valid Questionnaire questionnaire, Errors errors, RedirectAttributes redirectAttributes) {
        return adminService.addQuestionnaire(questionnaire, errors, redirectAttributes);
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@ModelAttribute @Valid QuestionDTO questionDTO, Errors errors,  RedirectAttributes redirectAttributes) {
        return adminService.addQuestion(questionDTO,errors,redirectAttributes);
    }
//    @PostMapping("/addQuestion")
//    public String addQuestion(@ModelAttribute("newQuestion") QuestionDTO questionDTO) {
//        adminService.addQuestion(questionDTO);
//        return "redirect:/admin";
//    }

    @DeleteMapping("/deleteQuestionnaire/{id}")
    public String deleteQuestionnaire(@PathVariable("id") int id) {
        adminService.deleteQuestionnaire(id);
        return "redirect:/admin";
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id) {
        adminService.deleteQuestion(id);
        return "redirect:/admin";
    }

    @GetMapping("")
    String getQuestionnaire(Model model) {
        List<Questionnaire> questionnaires = adminService.getQuestionnaires();
        model.addAttribute("questionnaire", questionnaires);
        return "admin";
    }


}
