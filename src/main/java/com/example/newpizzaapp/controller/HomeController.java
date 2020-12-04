package com.example.newpizzaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("")
public class HomeController {
    @GetMapping("/home")
    @ResponseBody
    public String hello(){
        return "Siema";
    }

    @GetMapping("/dom")
    public String hello2(Model model){
        return "drugaMetodka";
    }

}
