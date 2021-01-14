package com.example.newpizzaapp.model;


import javax.persistence.*;

@Entity
public class FoodOrderDetail {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    public FoodOrderDetail() {
    }

    public FoodOrderDetail(int quantity, Food food) {
        this.quantity = quantity;
        this.food = food;
    }

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
//                ", food=" + food.getFoodName() +
                ", quantity=" + quantity +
                '}';
    }
}
