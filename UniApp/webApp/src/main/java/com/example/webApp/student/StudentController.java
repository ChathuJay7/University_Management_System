package com.example.webApp.student;

import com.example.webApp.faculty.Faculty;
import com.example.webApp.faculty.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @Autowired
    private SportRepository sportRepo;

    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        List<Faculty> listFaculties = facultyRepo.findAll();
        List<Sport> listSports = sportRepo.findAll();

        model.addAttribute("student", new Student());
        model.addAttribute("listSports", listSports);
        model.addAttribute("listFaculties", listFaculties);

        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, HttpServletRequest request) {

        String[] detailIDs = request.getParameterValues("detailID");
        String[] detailSubjects = request.getParameterValues("detailSubject");
        String[] detailCodes = request.getParameterValues("detailCode");

        for (int i = 0; i < detailSubjects.length; i++) {
            if(detailIDs != null && detailIDs.length > 0)
            {
                student.setDetail(Integer.valueOf(detailIDs[i]), detailSubjects[i], detailCodes[i]);
            }
            else
            {
                student.addDetail(detailSubjects[i], detailCodes[i]);
            }
        }

        studentRepo.save(student);

        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("listStudents", listStudents);

        return "students";
    }

    @GetMapping("students/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Integer id, Model model){
        Student student = studentRepo.findById(id).get();
        model.addAttribute("student", student);

        List<Faculty> listFaculties = facultyRepo.findAll();
        model.addAttribute("listFaculties", listFaculties);

        List<Sport> listSports = sportRepo.findAll();
        model.addAttribute("listSports", listSports);

        return "student_form";
    }

    @GetMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
        studentRepo.deleteById(id);

        return "redirect:/students";
    }


}
