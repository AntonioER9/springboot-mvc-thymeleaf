package com.antonio.springboot.thymeleafdemo.controller;

import com.antonio.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create a student object
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        //add the list of countries to the model
        theModel.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.printf("First Name: %s\n", theStudent.getFirstName());
        System.out.printf("Last Name: %s\n", theStudent.getLastName());

        return "student-confirmation";
    }

}
