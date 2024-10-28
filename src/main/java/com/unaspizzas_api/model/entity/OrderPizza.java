package com.unaspizzas_api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_pizza")
public class OrderPizza {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_order")
    @JsonBackReference
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private Pizza pizza;

    private Integer quantity;

}
