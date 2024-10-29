package com.unaspizzas_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pizza_category")
@Data
public class PizzaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza_category")
    private Long idPizzaCategory;

    @Column(name = "name_pizza_category")
    private String namePizzaCategory;

}
