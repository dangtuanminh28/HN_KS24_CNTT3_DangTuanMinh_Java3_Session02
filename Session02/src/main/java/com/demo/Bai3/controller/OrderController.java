package com.demo.Bai3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.demo.Bai3.model.Order;

@Controller
public class OrderController {

    @Autowired
    ServletContext application;

    @GetMapping("/orders")
    public String listOrders(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORD001", "Máy tính Dell", 15000000, new Date()));
        orders.add(new Order("ORD002", "Chuột Logitech", 500000, new Date()));

        model.addAttribute("orderList", orders);

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        return "login";
    }
}
