package com.example.newpizzaapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order")
    private Set<FoodOrderDetail> itemsOrdered = new HashSet<>();


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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
