package com.example.newpizzaapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @GetMapping
    public String loadIndexPage() {
        return "index";
    }


}
