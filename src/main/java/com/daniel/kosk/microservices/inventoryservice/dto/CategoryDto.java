package com.daniel.kosk.microservices.inventoryservice.dto;

import jakarta.validation.constraints.NotNull;


import java.util.UUID;

public record CategoryDto(
        UUID id,
        @NotNull(message = "Name must be provided.")
        String name
) implements  ApiResponseDto {
}
