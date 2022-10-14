package com.example.webApp.student;

import javax.persistence.*;

@Entity
@Table(name="student_sub_details")
public class StudentSubDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String subject;

    @Column(length = 45, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentSubDetails(Integer id, String subject, String code, Student student) {
        this.id = id;
        this.subject = subject;
        this.code = code;
        this.student = student;
    }

    public StudentSubDetails() {

    }

    public StudentSubDetails(String subject, String code, Student student) {
        this.subject = subject;
        this.code = code;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = code;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString(){
        return subject + "=" + code;
    }
}
