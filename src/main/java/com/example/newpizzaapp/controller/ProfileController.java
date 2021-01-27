package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    Logger log = LoggerFactory.getLogger(ProfileController.class);

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String loadProfile(Model model, Authentication authentication) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User loggedUser = userService.getUserByLogin(userDetails.getUsername());
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("userDetails", userDetails);
        log.info("Profil użytkownika " + loggedUser);
        return "profile";
    }
}
