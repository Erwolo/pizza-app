package com.example.newpizzaapp.model;

public class FoodOrderDetail {

    private Long id;
    private Food food;
    private int quantity;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderFoodDetail{" +
                "id=" + id +
                ", food=" + food.getFoodName() +
                ", quantity=" + quantity +
                '}';
    }
}
