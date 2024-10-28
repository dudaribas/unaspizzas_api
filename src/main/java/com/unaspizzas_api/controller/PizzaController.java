package com.unaspizzas_api.controller;

import com.unaspizzas_api.model.dto.PizzaDTO;
import com.unaspizzas_api.model.entity.Pizza;
import com.unaspizzas_api.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unaspizzas_api.service.PizzaService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pizza")
@CrossOrigin(origins = "http://localhost:4200")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.findAll();
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) {
        return pizzaService.findById(id);
    }

    @PostMapping(consumes = "multipart/form-data")
    public Pizza createPizza(@ModelAttribute PizzaDTO pizzaDTO, @RequestPart MultipartFile image) throws IOException {
        return pizzaService.create(pizzaDTO, image);
    }

    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public Pizza updatePizza(@PathVariable Long id, @ModelAttribute PizzaDTO pizzaDTO, @RequestPart MultipartFile image) throws IOException {
        return pizzaService.update(id, pizzaDTO, image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}