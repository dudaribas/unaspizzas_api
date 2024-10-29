package com.unaspizzas_api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginDTO {

    @Schema(description = "E-mail do usuário", example = "usuario@example.com")
    private String email;

}