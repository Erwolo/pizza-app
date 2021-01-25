package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.model.MyAuthenticationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String loadIndexPage(Authentication authentication, Model model) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);

        return "index";
    }

    @GetMapping("/navbar")
    public String showNavbar() {
        return "fragments/navbar";
    }

}
