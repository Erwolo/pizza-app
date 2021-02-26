package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.model.FoodCategory;
import com.example.newpizzaapp.model.MyAuthenticationUtil;
import com.example.newpizzaapp.services.FoodCategoryService;
import com.example.newpizzaapp.services.FoodService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MenuController {
    Logger log = LoggerFactory.getLogger(MenuController.class);

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
        MyAuthenticationUtil.addToModelAuthDetails(model, authentication);
        model.addAttribute("foodService", foodService);
        model.addAttribute("allCategories", foodCategoryService.getAllCategories());
        model.addAttribute("emptyFood", new Food());
        model.addAttribute("emptyCategory", new FoodCategory());
        return "menu";
    }

    @PostMapping("/add-food-to-category")
    public String addnewFoodToCategory(@RequestParam("newCatId") Long id ,@ModelAttribute("emptyFood") Food food) {
        Long catId = id;
        food.setFoodCategory(foodCategoryService.getCategoryById(catId).get());
        foodService.addFood(food);
        log.info("Dodano nowa pozycje " + food);
        return "redirect:/menu";
    }

    @PostMapping("/remove-item-from-db")
    public String removeFoodFromDatabase(@RequestParam("foodId") Long id) {
        foodService.removeFoodById(id);
        return "redirect:/menu";
    }

    @PostMapping(value = "/add-to-cart")
    public String getFoosBySimplePathWithPathVariables
            (@RequestParam(value = "foodId") long idFood, @RequestParam(value = "quantity") int quantity) {
        Food food = foodService.getFoodById(idFood);
        orderController.addToCart(food, quantity);
        return "redirect:/menu";
    }

    @PostMapping("/add-menu-category")
    public String addMenuCategory(@ModelAttribute FoodCategory foodCategory) {
        log.info("Zapisano kategorie " + foodCategory);
        foodCategoryService.saveCategoryWithNextId(foodCategory);
        return "redirect:/menu";
    }

    @PostMapping("/remove-menu-category")
    public String removeMenuCategory(@RequestParam(value = "rmCategoryId") Long id) {
        foodCategoryService.removeCategoryById(id);
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
