package com.tutorial.servicec.repository;

import com.tutorial.servicec.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
