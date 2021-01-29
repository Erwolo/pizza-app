package com.example.newpizzaapp.services;


import com.example.newpizzaapp.model.Order;
import com.example.newpizzaapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findBetween(Long idLow, Long idHigh) {
        return orderRepository.findOrdersByIdBetween(idLow, idHigh);
    }

    @Override
    public List<Order> findToId(Long id) {
        return orderRepository.findOrdersByIdIsLessThan(id);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
