package com.example.newpizzaapp.model;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private long id;
    private String foodName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_category_id", nullable = false)
    private FoodCategory foodCategory;
    private float price;

    public Food() {
    }

    public Food(String nameOfFood, FoodCategory foodCategory, float price) {
        this.foodName = nameOfFood;
        this.foodCategory = foodCategory;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String nameOfFood) {
        this.foodName = nameOfFood;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", nameOfFood='" + foodName + '\'' +
                ", foodCategory=" + foodCategory.getCategoryName() +
                ", price=" + price +
                '}';
    }
}
