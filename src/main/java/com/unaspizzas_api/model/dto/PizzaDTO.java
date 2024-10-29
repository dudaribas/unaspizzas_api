package com.unaspizzas_api.model.dto;

import com.unaspizzas_api.model.entity.PizzaCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PizzaDTO {

    @Schema(description = "Nome da pizza", example = "Pizza Teste")
    private String name;

    @Schema(description = "Descrição da pizza", example = "Descrição teste")
    private String description;

    @Schema(description = "Preço da pizza", example = "99.99")
    private Double price;

    @Schema(description = "Categoria da pizza", example = "{ 'idPizzaCategory': 1 }")
    private String category;

}
