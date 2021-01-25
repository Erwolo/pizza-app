package com.example.newpizzaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderlistController {

    @GetMapping("/orderlist")
    public String getOrderlistView() {


        return "orderlist";
    }


}
