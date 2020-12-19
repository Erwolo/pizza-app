package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final FoodService foodService;

    @Autowired
    public MenuController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/menu")
    public String displayMenu(Model model) {
        model.addAttribute("pizzaList", foodService.getAllFromCategory("Pizza"));
        model.addAttribute("courseList", foodService.getAllFromCategory("Danie Glowne"));
        model.addAttribute("snackList", foodService.getAllFromCategory("Przekaski"));
        return "menu";
    }
}
