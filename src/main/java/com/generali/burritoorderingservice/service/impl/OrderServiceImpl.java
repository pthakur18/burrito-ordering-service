package com.generali.burritoorderingservice.service.impl;

import com.generali.burritoorderingservice.exception.ResourceNotFoundException;
import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.repository.OrderRepository;
import com.generali.burritoorderingservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * get order by order id
     * @param id
     * @return
     */
    @Override
    public Order getOrder(long id){
        Optional<Order> order  = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }
        else{
            throw new ResourceNotFoundException("Order not found with order id =" + id);
        }

    }
    /**
     * Get All Orders
     * @return
     */
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    /**
     * Save Order
     * @param order
     * @return
     */
    @Override
    public Order saveOrder(Order order) {

        return orderRepository.save(order);
    }
}


