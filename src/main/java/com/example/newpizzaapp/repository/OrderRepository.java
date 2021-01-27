package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByIdIsLessThan(Long id);
    List<Order> findOrdersByIdBetween(Long idLow, Long idHigh);

}
