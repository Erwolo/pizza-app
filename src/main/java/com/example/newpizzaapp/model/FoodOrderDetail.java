package com.example.newpizzaapp.model;


import javax.persistence.*;

@Entity
public class FoodOrderDetail {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id")
    private Food food;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
