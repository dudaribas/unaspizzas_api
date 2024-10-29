package com.unaspizzas_api.model.dto;

import com.unaspizzas_api.model.entity.PizzaCategory;
import lombok.Data;

@Data
public class PizzaDTO {

    private String name;
    private String description;
    private Double price;
    private String category;

}
