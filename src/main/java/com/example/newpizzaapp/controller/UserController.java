package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

}
