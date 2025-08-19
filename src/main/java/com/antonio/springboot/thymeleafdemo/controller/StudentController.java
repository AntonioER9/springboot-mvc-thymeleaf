package com.antonio.springboot.thymeleafdemo.controller;

import com.antonio.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create a student object
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.printf("First Name: %s\n", theStudent.getFirstName());
        System.out.printf("Last Name: %s\n", theStudent.getLastName());

        return "student-confirmation";
    }

}
