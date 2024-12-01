package com.unaspizzas_api.controller;

import com.unaspizzas_api.model.dto.OrderDTO;
import com.unaspizzas_api.model.entity.Order;
import com.unaspizzas_api.model.entity.StatusOrder;
import com.unaspizzas_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.create(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Order>> getAllByUser(@PathVariable Long idUser) {
        return new ResponseEntity<>(orderService.findAllByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(@RequestParam(required = false) List<Long> idStatusOrder) {

        if (idStatusOrder != null) {
            return new ResponseEntity<>(orderService.findAll(idStatusOrder), HttpStatus.OK);
        }

        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<Order> getById(@PathVariable Long idOrder) {
        return ResponseEntity.ok(orderService.findById(idOrder));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestBody StatusOrder statusOrder) {
        return new ResponseEntity<>(orderService.updateStatus(id, statusOrder), HttpStatus.OK);
    }

}
