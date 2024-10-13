package com.unaspizzas_api.service;

import com.unaspizzas_api.model.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unaspizzas_api.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, Pizza pizzaDetails) {
        Pizza pizza = findById(id);
        pizza.setName(pizzaDetails.getName());
        pizza.setDescription(pizzaDetails.getDescription());
        pizza.setPrice(pizzaDetails.getPrice());

        return pizzaRepository.save(pizza);
    }

    public void delete(Long id) {
        Pizza pizza = findById(id);
        pizzaRepository.delete(pizza);
    }
}