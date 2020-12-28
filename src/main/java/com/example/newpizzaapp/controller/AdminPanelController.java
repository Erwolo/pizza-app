package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminPanelController {
    Logger log = LoggerFactory.getLogger(AdminPanelController.class);

    private final FoodCategoryService foodCategoryService;
    private final FoodService foodService;


    public AdminPanelController(FoodCategoryService foodCategoryService, FoodService foodService) {
        this.foodCategoryService = foodCategoryService;
        this.foodService = foodService;
    }


    @GetMapping("/admin")
    public String adminPanel(Model model) {
        model.addAttribute("emptyMeal", new Food());
        model.addAttribute("foodCategories", foodCategoryService.getAllCategories());
        return "adminPanel";
    }

    @PostMapping("/add-meal")
    public String addMeal(@ModelAttribute(name = "emptyMeal") Food food) {
        foodService.addFood(food);
        log.info("Dodano jedzenie" + food);
        return "redirect:/admin";
    }


}