package com.unaspizzas_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unaspizzas_api.model.dto.PizzaDTO;
import com.unaspizzas_api.model.entity.Pizza;
import com.unaspizzas_api.model.entity.PizzaCategory;
import com.unaspizzas_api.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    private final ObjectMapper mapper = new ObjectMapper();


    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> findAll(Long idPizzaCategory) {
        return pizzaRepository.findAllByCategoryIdPizzaCategory(idPizzaCategory);
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza not found"));
    }

    public Pizza create(PizzaDTO pizzaDTO, MultipartFile image) throws IOException {
        Pizza pizza = pizzaDTOToEntity(pizzaDTO);

        String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());
        pizza.setImage(imageBase64);

        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDTO pizzaDTO, MultipartFile image) throws IOException {
        Pizza pizza = findById(id);

        pizza.setName(pizzaDTO.getName());
        pizza.setDescription(pizzaDTO.getDescription());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setCategory(categoryStringToPizzaCategory(pizzaDTO.getCategory()));

        if (image != null) {
            String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());
            pizza.setImage(imageBase64);
        }

        return pizzaRepository.save(pizza);
    }

    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }

    private Pizza pizzaDTOToEntity(PizzaDTO pizzaDTO) throws JsonProcessingException {
        Pizza pizza = new Pizza();
        PizzaCategory pizzaCategory = categoryStringToPizzaCategory(pizzaDTO.getCategory());

        pizza.setName(pizzaDTO.getName());
        pizza.setDescription(pizzaDTO.getDescription());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setCategory(pizzaCategory);

        return pizza;
    }

    private PizzaCategory categoryStringToPizzaCategory(String category) throws JsonProcessingException {
        return mapper.readValue(category, PizzaCategory.class);
    }

}