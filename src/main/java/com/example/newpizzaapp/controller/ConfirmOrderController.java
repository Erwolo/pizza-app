package com.example.newpizzaapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConfirmOrderController {

    Logger log = LoggerFactory.getLogger(ConfirmOrderController.class);

    private final OrderController orderController;

    public ConfirmOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @GetMapping("/confirmorder")
    public String getConfirmView(Model model) {
        model.addAttribute("cart", orderController.getShoppingCart());

        return "confirmorder";
    }

    @PostMapping
    public String makeOrder() {



        return "redirect:/confirmorder";
    }

}
