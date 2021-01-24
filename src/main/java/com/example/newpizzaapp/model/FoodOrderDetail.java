package com.example.newpizzaapp.model;


import javax.persistence.*;

@Entity
public class FoodOrderDetail {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id")
    private Food food;
    @Column
    private int quantity;

    public FoodOrderDetail() {
    }

    public FoodOrderDetail(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
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
                ", quantity=" + quantity +
                '}';
    }
}
