package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.model.UserAddress;
import com.example.newpizzaapp.services.UserAddressService;
import com.example.newpizzaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    private final UserService userService;
    private final UserAddressService userAddressService;

    public AddressController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    @PostMapping("/new-address")
    public String addNewAddress(Model model, Authentication authentication) {
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        User user =  userService.getUserByLogin(((UserDetails) authentication.getPrincipal()).getUsername());
        model.addAttribute("currentUser", user);
        model.addAttribute("emptyAddress", new UserAddress());

        return "newaddress";
    }

    @PostMapping("/save-new-address")
    public String saveNewAddress(@ModelAttribute UserAddress userAddress, @ModelAttribute User user) {
        userAddress.setUser(user);
        userAddressService.saveAddressGetObj(userAddress);
        return "redirect:/profile";
    }

}
