package com.example.webApp.dean;

import com.example.webApp.faculty.Faculty;
import com.example.webApp.faculty.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeanController {

    @Autowired
    private DeanRepository deanRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @GetMapping("/deans/new")
    public String showCreateNewDeanForm(Model model) {

        List<Faculty> listFaculties = facultyRepo.findAll();

        model.addAttribute("listFaculties", listFaculties);
        model.addAttribute("dean", new Dean());

        return "dean_form";
    }

    @PostMapping("/deans/save")
    public String saveDean(Dean dean) {
        deanRepo.save(dean);

        return "redirect:/deans";
    }

    @GetMapping("/deans")
    public String listDeans(Model model) {
        List<Dean> listDeans = deanRepo.findAll();
        model.addAttribute("listDeans", listDeans);

        return "deans";
    }

    @GetMapping("/deans/edit/{id}")
    public String showEditDeanForm(@PathVariable("id") Integer id, Model model) {
        List<Faculty> listFaculties = facultyRepo.findAll();
        Dean dean = deanRepo.findById(id).get();

        model.addAttribute("listFaculties", listFaculties);
        model.addAttribute("dean", dean);

        return "dean_form";
    }

}
