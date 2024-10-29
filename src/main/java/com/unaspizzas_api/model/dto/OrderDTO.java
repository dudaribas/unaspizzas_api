package com.unaspizzas_api.model.dto;

import com.unaspizzas_api.model.entity.OrderPizza;
import com.unaspizzas_api.model.entity.StatusOrder;
import com.unaspizzas_api.model.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private User user;
    private List<OrderPizza> orderPizzas;
    private StatusOrder statusOrder;

    @Schema(description = "Preço total do pedido", example = "129.99")
    private Double totalPrice;

}
