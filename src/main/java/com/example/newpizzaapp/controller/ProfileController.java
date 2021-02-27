package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.services.UserAddressService;
import com.example.newpizzaapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    Logger log = LoggerFactory.getLogger(ProfileController.class);

    private final UserService userService;
    private final UserAddressService userAddressService;
    UserDetails userDetails;

    public ProfileController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    @GetMapping("/profile")
    public String loadProfile(Model model, Authentication authentication) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        userDetails = (UserDetails) authentication.getPrincipal();
        User loggedUser = userService.getUserByLogin(userDetails.getUsername());
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("userAddresses", userAddressService.getUserAdresses(userDetails.getUsername()));
        return "profile";
    }

    @PostMapping("/change-password")
    public String changePassword
            (
                    @RequestParam(value = "prevPass") String prevPass,
                    @RequestParam(value = "newPass") String newPass,
                    @RequestParam(value = "newPassReEnter") String newPassReEnter
            ) {
        User user = userService.getUserByLogin(userDetails.getUsername());
        if (user.getPassword().equals(prevPass) && newPass.equals(newPassReEnter)) {
            userService.changePassword(user, newPass);
            log.info("Zmieniono haslo " + user);
        } else {
            log.info("Niepoprawna zmiana hasla " + user);
        }

        return "redirect:/profile";
    }

}
