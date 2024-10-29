package com.unaspizzas_api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {

    @Schema(description = "Nome do usuário", example = "Exemplo nome")
    private String name;

    @Schema(description = "E-mail do usuário", example = "usuario@example.com")
    private String email;

    @Schema(description = "Endereço do usuário", example = "Rua Exemplo, 10")
    private String address;

}
