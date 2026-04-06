package com.demo.Bai3.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        System.out.println("Login attempt with: " + username);
        boolean isAdmin = "admin".equals(username) && "admin123".equals(password);
        boolean isStaff = "staff".equals(username) && "staff123".equals(password);

        if (isAdmin || isStaff) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", isAdmin ? "Quản trị viên" : "Nhân viên");

            return "redirect:/orders";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu! Vui lòng thử lại.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}