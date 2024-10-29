package com.unaspizzas_api.controller;

import com.unaspizzas_api.model.dto.OrderDTO;
import com.unaspizzas_api.model.entity.Order;
import com.unaspizzas_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.create(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Order>> getAllByUser(@PathVariable Long idUser) {
        return new ResponseEntity<>(orderService.findAllByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

}
