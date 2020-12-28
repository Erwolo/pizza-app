package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    private final FoodCategoryService foodCategoryService;
    private final FoodService foodService;

    public HomeController(FoodCategoryService foodCategoryService, FoodService foodService) {
        this.foodCategoryService = foodCategoryService;
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String loadIndexPage(Model model) {

        model.addAttribute("foodCategories", foodCategoryService.getAllCategories());
        model.addAttribute("pizzaList", foodService.getAllFromCategory("Pizza"));
        model.addAttribute("mainCourseList", foodService.getAllFromCategory("Danie Glowne"));
        model.addAttribute("snackList", foodService.getAllFromCategory("Przekaski"));

        return "index";
    }


}
