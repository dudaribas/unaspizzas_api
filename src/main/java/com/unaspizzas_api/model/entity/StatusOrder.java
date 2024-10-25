package com.unaspizzas_api.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "status_order")
@Data
public class StatusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_order")
    private Long idStatusOrder;

    @Column(name = "name_status")
    private String nameStatus;

}
