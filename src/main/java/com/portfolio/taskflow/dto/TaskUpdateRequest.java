package com.portfolio.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskUpdateRequest(
        @NotBlank(message = "The tittle is request")
        @Size(max = 100, message = "The title must have a maximun of 100 characters")
        String title,

        @Size(max = 500, message = "The description must have a maximum of 500 characters")
        String description
) {
}
