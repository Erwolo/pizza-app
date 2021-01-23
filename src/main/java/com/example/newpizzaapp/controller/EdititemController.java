package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EdititemController {

    Logger log = LoggerFactory.getLogger(EdititemController.class);

    private final FoodService foodService;

    public EdititemController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/edit-item")
    public String getEdititemView(Model model, @RequestParam("foodId") long id) {
        model.addAttribute("editedFood", foodService.getFoodById(id));
        return "edititem";
    }

    @Transactional
    @PostMapping("/update-item")
    public String updateItem(@RequestParam("foodId") long id,
                             @RequestParam("foodName") String name,
                             @RequestParam("foodPrice") float price) {
        foodService.updateFoodName(id, name);
        foodService.updateFoodPrice(id, price);

        return "redirect:/menu";
    }

}
