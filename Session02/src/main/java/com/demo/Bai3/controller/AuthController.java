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
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String user,
            @RequestParam("password") String pass,
            HttpSession session,
            Model model) {

        if (("admin".equals(user) && "admin123".equals(pass)) ||
                ("staff".equals(user) && "staff123".equals(pass))) {

            session.setAttribute("loggedUser", user);
            session.setAttribute("role", user.equals("admin") ? "Quản trị viên" : "Nhân viên");

            return "redirect:/orders";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}