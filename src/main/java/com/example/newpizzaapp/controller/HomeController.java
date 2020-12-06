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

    @ModelAttribute("usersMethod")
    public List<User> allUsersList() {
        return userService.getAllUsers();
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
//        model.addAllAttributes(userService.getAllUsers());

//        model.addAttribute("fName1", userService.getAllUsers().get(0).getFirstName());
//        model.addAttribute("lName1", userService.getAllUsers().get(0).getLastName());
//        model.addAttribute("fName2", userService.getAllUsers().get(1).getFirstName());
//        model.addAttribute("lName2", userService.getAllUsers().get(1).getLastName());
        return "users";
    }

}
