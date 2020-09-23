package com.thewalking.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thewalking.model.Order;
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
