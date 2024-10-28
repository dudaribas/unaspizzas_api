package com.unaspizzas_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unaspizzas_api.model.dto.PizzaDTO;
import com.unaspizzas_api.model.entity.Pizza;
import com.unaspizzas_api.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PizzaService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza not found"));
    }

    public Pizza create(PizzaDTO pizzaDTO, MultipartFile image) throws IOException {
        Pizza pizza = mapper.convertValue(pizzaDTO, Pizza.class);
        String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());
        pizza.setImage(imageBase64);

        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDTO pizzaDTO, MultipartFile image) throws IOException {
        Pizza pizza = findById(id);
        String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());

        pizza.setName(pizzaDTO.getName());
        pizza.setDescription(pizzaDTO.getDescription());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setImage(imageBase64);

        return pizzaRepository.save(pizza);
    }

    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }

}