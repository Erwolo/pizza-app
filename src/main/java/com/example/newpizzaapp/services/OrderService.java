package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);
    List<Order> getAllOrders();
    List<Order> findBetween(Long idLow, Long idHigh);
    List<Order> findToId(Long id);

}
