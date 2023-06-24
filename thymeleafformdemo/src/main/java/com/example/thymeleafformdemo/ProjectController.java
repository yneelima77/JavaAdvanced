package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

// sourced from from:
//
// https://attacomsian.com/blog/spring-boot-thymeleaf-form-handling
//

@Controller
public class ProjectController {
   List<Project> currentProjects = new ArrayList<>();

    @GetMapping("/create-project")
    public String createProjectForm(Model model) {

        model.addAttribute("project", new Project());
        return "create-project";
    }

    @PostMapping("/save-project")
    public String saveProjectSubmission(@ModelAttribute Project project) {
/*
        public String saveProjectSubmission(Model model, @ModelAttribute Project project) {
       currentProjects.add(project);
        model.addAttribute("projectsList", currentProjects);
        return "projectsList";*/

        // TODO: save project in DB here

        currentProjects.add(project);
        return "result";
    }

    @GetMapping("/saved-project")
    public String GetsavedProject(Model model) {
       //currentProjects.add(project);
        model.addAttribute("projectsList", currentProjects);
        return "projectsList";
    }
}