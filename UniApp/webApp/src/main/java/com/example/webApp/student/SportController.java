package com.example.webApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SportController {

    @Autowired
    private SportRepository repo;

    @GetMapping("/sports")
    public String listSports(Model model) {
        List<Sport> listSports = repo.findAll();
        model.addAttribute("listSports", listSports);

        return "sports";
    }

    @GetMapping("sports/new")
    public String showSportNewForm(Model model) {
        model.addAttribute("sport", new Sport());

        return "sport_form";
    }

    @PostMapping("/sports/save")
    public String saveSport(Sport sport) {
        repo.save(sport);

        return "redirect:/sports";
    }
}
