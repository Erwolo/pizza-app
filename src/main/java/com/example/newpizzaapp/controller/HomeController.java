package com.example.newpizzaapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @GetMapping
    public String indexPage() {
        return "index";
    }

/*    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Test response", HttpStatus.OK);
    }*/

}
