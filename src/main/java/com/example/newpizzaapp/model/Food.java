package com.example.newpizzaapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private long id;
    private String foodName;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "food_category_id", nullable = false)
    private FoodCategory foodCategory;
    private float price;




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
        setFoodCategory(foodCategory, true);
    }

    public float getPrice() {
        return price;
    }

    void setFoodCategory(FoodCategory foodCategory, boolean add) {
        this.foodCategory = foodCategory;
        if (foodCategory != null && add) {
            foodCategory.addFood(this, false);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return id == food.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
