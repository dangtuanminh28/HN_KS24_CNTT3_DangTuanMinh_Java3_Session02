package com.demo.Bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;
import com.demo.Bai2.model.Student;

@Controller
public class StudentController {

    @GetMapping("/student-list")
    public String listStudent(Model model) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Minh", 8));
        list.add(new Student( "Khanh", 9));

        model.addAttribute("students", list);

        return "student-list";
    }
}