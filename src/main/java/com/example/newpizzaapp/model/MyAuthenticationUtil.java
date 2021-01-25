package com.example.newpizzaapp.model;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public class MyAuthenticationUtil {

    public static void addToModelAuthDetails(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", isLogged(authentication));
        model.addAttribute("isAdmin", isAdmin(authentication));
    }

    public static boolean isLogged(Authentication authentication) {
        if (authentication != null) return authentication.isAuthenticated();
        return false;
    }

    public static boolean isAdmin(Authentication authentication) {
        if (authentication != null) {
            return authentication.getAuthorities().stream().anyMatch(t -> t.getAuthority().equals("ROLE_ADMIN"));
        }
        return false;
    }

}
