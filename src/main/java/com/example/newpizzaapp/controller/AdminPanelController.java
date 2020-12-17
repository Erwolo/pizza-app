package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminPanelController {

    @GetMapping("/admin")
    public String adminPanel(Model model) {
        model.addAttribute("emptyMeal", new Food());
        return "adminPanel";
    }

    @PostMapping("/add-meal")
    public String dodajDanie() {

        return "redirect/admin";
    }


}