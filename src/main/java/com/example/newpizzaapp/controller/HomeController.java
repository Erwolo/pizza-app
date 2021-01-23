package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {


    @GetMapping("/")
    public String loadIndexPage() {

        return "index";
    }

    @GetMapping("/navbar")
    public String showNavbar() {
        return "fragments/navbar";
    }

}
