package com.example.newpizzaapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class FoodCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;
    @OneToMany(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REMOVE
            },
            mappedBy = "foodCategory",
            fetch = FetchType.EAGER
    )
    private Set<Food> foodSet = new HashSet<>();

    public FoodCategory() {
    }

    public void addFood(Food food) {
        addFood(food, true);
    }

    void addFood(Food food, boolean set) {
        if (food != null) {
            getFoodSet().add(food);
            if (set) {
                food.setFoodCategory(this, false);
            }
        }
    }

    public void removeFood(Food food) {
        getFoodSet().remove(food);
        food.setFoodCategory(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }

    @Override
    public String toString() {
        return "FoodCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodCategory)) return false;
        FoodCategory that = (FoodCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(categoryName, that.categoryName) && Objects.equals(foodSet, that.foodSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
