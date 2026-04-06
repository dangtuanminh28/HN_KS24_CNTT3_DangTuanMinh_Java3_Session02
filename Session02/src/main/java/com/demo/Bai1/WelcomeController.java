package com.demo.Bai1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String displayWelcome(Model model) {

        String employeeName = "Dang Tuan Minh";
        model.addAttribute("name", employeeName);
        return "welcome";
    }
}