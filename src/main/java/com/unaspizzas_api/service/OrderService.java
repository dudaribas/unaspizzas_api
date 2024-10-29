package com.unaspizzas_api.service;


import com.unaspizzas_api.model.entity.Order;
import com.unaspizzas_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllByIdUser(Long idUser) {
        return orderRepository.findAllByUserIdUser(idUser);
    }

}
