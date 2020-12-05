package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Qualifier("defaultUserSerivice")
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String dodajUzytkownika(@RequestParam String firstName, @RequestParam String lastName) {
        userService.saveUser(firstName, lastName);
        return "Uzytkownik zapisany";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
