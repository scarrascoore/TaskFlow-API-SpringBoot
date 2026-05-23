package com.portfolio.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskCreateRequest(
        @NotBlank(message = "El titulo es requerido")
        @Size(max = 100, message = "La descripcion debe tener máximo 100 caracteres")
        String title,

        @Size(max = 500, message = "La descripcion debe tener máximo 500 caracteres")
        String description
){
}


