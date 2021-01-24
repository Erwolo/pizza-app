package com.example.newpizzaapp.services;


import com.example.newpizzaapp.model.Order;
import com.example.newpizzaapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }



}
