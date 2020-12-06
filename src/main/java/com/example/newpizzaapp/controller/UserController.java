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

    @Qualifier("defaultUserSerivice")
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String dodajUzytkownika(@RequestParam String firstName, @RequestParam String lastName) {
        userService.saveUser(firstName, lastName);

        return "Uzytkownik zapisany";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    // Nie wiem czy jest jakas roznica z tym wyzej
    @ModelAttribute("usersMethod")
    public List<User> allUsersList() {
        return userService.getAllUsers();
    }

}
