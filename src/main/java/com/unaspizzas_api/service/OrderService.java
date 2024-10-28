package com.unaspizzas_api.service;


import com.unaspizzas_api.model.entity.Order;
import com.unaspizzas_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

}
