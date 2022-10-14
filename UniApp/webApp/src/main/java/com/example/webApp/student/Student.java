package com.example.webApp.student;

import com.example.webApp.faculty.Faculty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = false)
    private String name;

    private int year;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentSubDetails> details = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<StudentSubDetails> getDetails() {
        return details;
    }

    public void setDetails(List<StudentSubDetails> details) {
        this.details = details;
    }

    public void addDetail(String subject, String code) {
        this.details.add(new StudentSubDetails(subject, code, this));
    }

    public void setDetail(Integer id, String subject, String code) {
        this.details.add(new StudentSubDetails(id, subject, code, this));
    }


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_sport",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id")
    )
    private Set<Sport> sports = new HashSet<>();

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public void addSport(Sport sport) {
        this.sports.add(sport);
    }

}
