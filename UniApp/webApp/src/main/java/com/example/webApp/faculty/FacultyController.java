package com.example.webApp.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyRepository repo;

    @GetMapping("/faculties")
    public String listFaculties(Model model) {
        List<Faculty> listFaculties = repo.findAll();
        model.addAttribute("listFaculties", listFaculties);

        return "faculties";
    }

    @GetMapping("faculties/new")
    public String showFacultyNewForm(Model model) {
        model.addAttribute("faculty", new Faculty());

        return "faculty_form";
    }

    @PostMapping("/faculties/save")
    public String saveCategory(Faculty faculty) {
        repo.save(faculty);

        return "redirect:/faculties";
    }

}
