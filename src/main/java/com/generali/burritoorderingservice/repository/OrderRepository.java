package com.generali.burritoorderingservice.repository;

import com.generali.burritoorderingservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
