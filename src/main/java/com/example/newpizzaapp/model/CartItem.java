package com.example.newpizzaapp.model;

public class CartItem {
    Food food;
    Integer quantity;

    public CartItem(Food food) {
        this.food = food;
        this.quantity = 1;
    }

    public CartItem(Food food, Integer quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public void increaseQuantity() {
        quantity = quantity + 1;
    }

    public void increaseQuantityBy(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isInstanceOfFood(Food other) {
        return food.equals(other);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "food=" + food +
                ", quantity=" + quantity +
                '}';
    }
}
