package com.demo.Bai3.controller;

import com.demo.Bai3.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private ServletContext application; // Dùng để truy cập Application Scope

    @GetMapping("/orders")
    public String listOrders(HttpSession session, Model model) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("ORD-001", "Macbook Pro M3", 45000000.0, new Date()));
        orderList.add(new Order("ORD-002", "iPhone 15 Pro Max", 32000000.0, new Date()));
        orderList.add(new Order("ORD-003", "Sony WH-1000XM5", 8500000.0, new Date()));

        model.addAttribute("orderList", orderList);

        return "orders";
    }
}