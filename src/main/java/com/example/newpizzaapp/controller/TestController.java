package com.example.newpizzaapp.controller;


import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.repository.RoleRepository;
import com.example.newpizzaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class TestController {

    @Qualifier("defaultUserService")
    private final UserService userService;

    private final RoleRepository roleRepository;

    public TestController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @ModelAttribute
    public String loadSth(Model model) {

        model.addAttribute("zmienna", "wartosc dla addAttribute");
        return "wartosc zwrocona";
    }

    @RequestMapping("/test")
    public String test1(Model model) {
        System.out.println(roleRepository.findAllByUsersId(6L));
        User u = userService.getUserById(6L);
        model.addAttribute("dummyUser", u);
        return "test";
    }


}
