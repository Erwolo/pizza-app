package com.example.newpizzaapp.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Nullable
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Set<FoodOrderDetail> itemsOrdered = new HashSet<>();
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    private float orderTotal;
    private boolean isPaid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<FoodOrderDetail> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(Set<FoodOrderDetail> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isUserEmpty() {
        if (this.user == null) return true;
            return false;
    }

    @Override
    public String toString() {

        return "Order{" +
                "id=" + id +
                ", user=" + (user != null ? user.getEmail() : "") +
                ", itemsOrdered=" + itemsOrdered +
                ", isPaid=" + isPaid +
                '}';
    }
}
