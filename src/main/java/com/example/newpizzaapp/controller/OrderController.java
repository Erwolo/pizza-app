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

    private List<CartItem> shoppingCart = new ArrayList<>();


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

    public void removeItemFromCart(Food food) {
        Optional<CartItem> tmpFood = shoppingCart.stream().filter(item -> item.isInstanceOfFood(food)).findAny();
        if (tmpFood.isPresent()) {
            CartItem item = tmpFood.get();
            shoppingCart.remove(item);
        }
    }

    public void setInCartItemQuant(Food food, Integer quantity) {
        Optional<CartItem> tmpFood = shoppingCart.stream().filter(item -> item.isInstanceOfFood(food)).findAny();
        if (tmpFood.isPresent() && !(tmpFood.get().getQuantity().equals(quantity))) {
            CartItem item = tmpFood.get();
            if (quantity > 0) {
                item.setQuantity(quantity);
            }
            else {
                item.setQuantity(1);
            }
        }
        else {
            shoppingCart.add(new CartItem(food, quantity));
        }
        log.info(shoppingCart.toString());
    }

    public float getCartTotal() {
        float total = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            total = total + shoppingCart.get(i).getFood().getPrice() * shoppingCart.get(i).getQuantity();
        }
        return total;
    }

    public List<CartItem> getShoppingCart() {
        return shoppingCart;
    }
}
