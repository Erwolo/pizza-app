package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.model.UserAddress;
import com.example.newpizzaapp.services.UserAddressService;
import com.example.newpizzaapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {
    Logger log = LoggerFactory.getLogger(RegisterController.class);

    private final UserService userService;
    private final UserAddressService userAddressService;


    public RegisterController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    @GetMapping("/register")
    public String registerForm(
            Model model, Authentication authentication,
            @RequestParam(name = "wrong_pass", required = false, defaultValue = "false") boolean isPasswordWrong,
            @RequestParam(name = "register_success", required = false, defaultValue = "false") boolean isRegSuccess
    ) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        model.addAttribute("emptyUser", new User());
        if (isPasswordWrong) {
            log.info("Haslo zle");
        }
        model.addAttribute("isRegSuccess", isRegSuccess);
        model.addAttribute("isPasswordWrong", isPasswordWrong);
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(
            @ModelAttribute User user,
            @RequestParam("reEnteredPassword") String retypedPassword,
            @RequestParam("regStreet") String streetName,
            @RequestParam("regNumber") String streetNumber,
            @RequestParam("regApartment") String apartment
    ) {
        if(!retypedPassword.equals(user.getPassword())) {
            log.info("Haslo zle");
            return "redirect:/register?wrong_pass=true";
        }
        UserAddress tmpAddress = userAddressService.saveAddressGetObj(new UserAddress(streetName, streetNumber, apartment));
        user.setActive(true);
        user.getAddresses().add(tmpAddress);
        userService.addRoleUser(user);
        userService.saveUser(user);
        log.info("Dodano uzytkownika " + user.toString());
        return "redirect:/register?register_success=true";
    }

}
