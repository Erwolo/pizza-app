package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
