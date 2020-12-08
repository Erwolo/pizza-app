package com.example.newpizzaapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @PostMapping("/test")
    public String test1() {

        return "test";
    }


}
