package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MenuController {

    private final FoodService foodService;
    private final FoodCategoryService foodCategoryService;
    private final OrderController orderController;

    public MenuController(FoodService foodService, OrderController orderController, FoodCategoryService foodCategoryService) {
        this.foodService = foodService;
        this.orderController = orderController;
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping("/menu")
    public String displayMenu(Model model, Authentication authentication) {
        boolean isAdmin = false;
        boolean isLoggedIn = false;
        if (authentication != null) {
            isAdmin = authentication.getAuthorities().stream().anyMatch(t -> t.getAuthority().equals("ROLE_ADMIN"));
            isLoggedIn = true;
        }

        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("foodService", foodService);
        model.addAttribute("allCategories", foodCategoryService.getAllCategories());
        return "menu";
    }

    @PostMapping(value = "/add-to-cart")
    public String getFoosBySimplePathWithPathVariables
            (@RequestParam(value = "foodId") long idFood, @RequestParam(value = "quantity") int quantity) {
        Food food = foodService.getFoodById(idFood);
        orderController.addToCart(food, quantity);
        return "redirect:/menu";
    }


//    @Secured("ROLE_ADMIN")
//    @RolesAllowed("ROLE_ADMIN")
//    @PreAuthorize("authentication.")
/*    @ModelAttribute("testString")
    public String addTestString() {
        return "Zalogowano jako admin";
    }*/

}
