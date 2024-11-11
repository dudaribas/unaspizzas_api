package com.unaspizzas_api.controller;

import com.unaspizzas_api.model.dto.PizzaDTO;
import com.unaspizzas_api.model.entity.Pizza;
import com.unaspizzas_api.service.PizzaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizza")
@CrossOrigin(origins = "http://localhost:4200")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas(@RequestParam(required = false) Long idPizzaCategory) {

        if (idPizzaCategory != null) {
            return ResponseEntity.ok(pizzaService.findAll(idPizzaCategory));
        }

        return ResponseEntity.ok(pizzaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.findById(id));
    }

    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pizza> createPizza(@ModelAttribute PizzaDTO pizzaDTO, @RequestPart MultipartFile image) throws IOException {
        return new ResponseEntity<>(pizzaService.create(pizzaDTO, image), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @ModelAttribute PizzaDTO pizzaDTO, @RequestPart(required = false) MultipartFile image) throws IOException {
        return ResponseEntity.ok(pizzaService.update(id, pizzaDTO, image));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}