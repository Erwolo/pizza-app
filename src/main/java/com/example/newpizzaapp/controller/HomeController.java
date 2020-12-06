package com.example.newpizzaapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping
    public String indexPage() {
        return "index";
    }


}
