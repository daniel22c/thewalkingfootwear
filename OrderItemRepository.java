package com.thewalking.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thewalking.model.Order;
import com.thewalking.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}