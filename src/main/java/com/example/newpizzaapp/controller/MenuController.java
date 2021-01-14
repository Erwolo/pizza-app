package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.services.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class MenuController {

    private final FoodService foodService;
    private final OrderController orderController;

    public MenuController(FoodService foodService, OrderController orderController) {
        this.foodService = foodService;
        this.orderController = orderController;
    }

    @GetMapping("/menu")
    public String displayMenu(Model model) {
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
