package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MenuController {

    private final FoodService foodService;
    private final FoodCategoryService foodCategoryService;
    private final OrderController orderController;

    public MenuController(FoodService foodService, OrderController orderController, FoodCategoryService foodCategoryService) {
        this.foodService = foodService;
        this.orderController = orderController;
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping("/menu")
    public String displayMenu(Model model) {
        model.addAttribute("foodService", foodService);
        model.addAttribute("allCategories", foodCategoryService.getAllCategories());
        model.addAttribute("pizzaList", foodService.getAllFromCategory("Pizza"));
        model.addAttribute("courseList", foodService.getAllFromCategory("Danie Glowne"));
        model.addAttribute("snackList", foodService.getAllFromCategory("Przekaski"));
        return "menu";
    }

    /*@GetMapping("/add-to-cart")
    public String addToCart(@PathParam(value = "idFood") Long foodId) {
        Food food = foodService.getFoodById(foodId);
        orderController.addToCart(food, 1);
        return "redirect:/menu";
    }*/

    @GetMapping(value = "/add-to-cart/{idFood}")
    public String getFoosBySimplePathWithPathVariables
            (@PathVariable long idFood) {
        Food food = foodService.getFoodById(idFood);
        orderController.addToCart(food, 1);
        return "redirect:/menu";
    }

    }
