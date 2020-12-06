package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
    Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Qualifier("defaultUserService")
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("emptyUser", new User());
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        log.info("Dodano uzytkownika " + user.toString());
        return "redirect:/register";
    }

}
