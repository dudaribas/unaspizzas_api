package com.unaspizzas_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pizza")
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza")
    private Long idPizza;

    private String name;

    private String description;

    private Double price;
}