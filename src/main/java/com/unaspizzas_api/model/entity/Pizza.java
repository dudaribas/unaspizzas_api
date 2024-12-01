package com.unaspizzas_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza")
    private Long idPizza;

    private String name;
    private String description;
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza_category")
    private PizzaCategory category;

    @Lob
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

}