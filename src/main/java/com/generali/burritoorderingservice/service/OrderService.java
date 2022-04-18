package com.generali.burritoorderingservice.service;

import com.generali.burritoorderingservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public Order getOrder(long id);

    public List<Order> getAllOrders();

    public Order saveOrder(Order order);


}
