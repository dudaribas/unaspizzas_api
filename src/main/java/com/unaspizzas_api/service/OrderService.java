package com.unaspizzas_api.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.unaspizzas_api.model.dto.OrderDTO;
import com.unaspizzas_api.model.entity.Order;
import com.unaspizzas_api.model.entity.StatusOrder;
import com.unaspizzas_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    public Order create(OrderDTO orderDTO) {
        return orderRepository.save(orderDTOToEntity(orderDTO));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAll(List<Long> idStatusOrder) {
        return orderRepository.findAllByStatusOrderIdStatusOrderIn(idStatusOrder);
    }

    public List<Order> findAllByIdUser(Long idUser) {
        return orderRepository.findAllByUserIdUser(idUser);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    private Order orderDTOToEntity(OrderDTO orderDTO) {
        return mapper.convertValue(orderDTO, Order.class);
    }

    public Order updateStatus(Long orderId, StatusOrder statusOrder) {

        Order orderDB = orderRepository.findById(orderId).orElseThrow();

        orderDB.setStatusOrder(statusOrder);
        orderRepository.save(orderDB);

        return orderDB;
    }

}
