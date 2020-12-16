package com.example.newpizzaapp.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ErrorController {

    public String defaultError() {

        return "error";
    }
}
