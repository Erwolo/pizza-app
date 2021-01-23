package com.example.newpizzaapp.controller;

import com.example.newpizzaapp.model.CartItem;
import com.example.newpizzaapp.model.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionScope
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    //    List<FoodOrderDetail> shoppingCart = new ArrayList<>();
    private List<CartItem> shoppingCart = new ArrayList<>();

/*    public void addToCart(FoodOrderDetail foodOrderDetail) {
        shoppingCart.add(foodOrderDetail);
    }

    public void removeFromCart(FoodOrderDetail foodOrderDetail) {
        shoppingCart.remove(foodOrderDetail);
    }*/


    public void addToCart(Food food, Integer quantity) {
        Optional<CartItem> tmpFood = shoppingCart.stream().filter(item -> item.isInstanceOfFood(food)).findAny();
        if (tmpFood.isPresent()) {
            CartItem item = tmpFood.get();
            item.increaseQuantityBy(quantity);
        }
        else {
            shoppingCart.add(new CartItem(food, quantity));
        }
        log.info(shoppingCart.toString());
    }

    public List<CartItem> getShoppingCart() {
        return shoppingCart;
    }
}
