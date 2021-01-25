package com.example.newpizzaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavbarController {

    @GetMapping("/navi")
    public String displayNavbar() {
        return "fragments/navbar";
    }

}
