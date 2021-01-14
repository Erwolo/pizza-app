package com.example.newpizzaapp.model;

import java.util.HashSet;
import java.util.Set;


public class Order {
    private Long id;
    private User user;
    private DeliveryAddress deliveryAddress;
    private Set<FoodOrderDetail> itemsOrdered = new HashSet<>();


}
