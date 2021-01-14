package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.model.FoodOrderDetail;
import com.example.newpizzaapp.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

//    List<FoodOrderDetail> shoppingCart = new ArrayList<>();
    List<Pair<Food, Integer>> shoppingCart = new ArrayList<>();

/*    public void addToCart(FoodOrderDetail foodOrderDetail) {
        shoppingCart.add(foodOrderDetail);
    }

    public void removeFromCart(FoodOrderDetail foodOrderDetail) {
        shoppingCart.remove(foodOrderDetail);
    }*/

    public void addToCart(Food food, Integer quantity) {
        shoppingCart.add(Pair.of(food, quantity));
        log.info(shoppingCart.toString());
    }

}
