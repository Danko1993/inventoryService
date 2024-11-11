package com.daniel.kosk.microservices.inventoryservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductDto(
        UUID id,
        @NotBlank(message = "Name must be provided.")
        String name,
        @NotBlank(message = "Description must be provided.")
        String description,
        @NotNull(message = "Category must be provided.")
        String categoryName,
        @NotNull(message = "Price must be provided.")
        Double price,
        @NotNull(message = "Stock quantity must be provided.")
        Integer stockQuantity,
        String imagePath,
        @NotBlank(message = "Producer code must be provided.")
        String producerCode,
        @NotNull(message = "Weight must be provided.")
        Double weight,
        @NotBlank(message = "Brand must be provided.")
        String brand,
        @NotBlank(message = "Model must be provided.")
        String model,
        @NotBlank(message = "Currency must be provided.")
        String currency
) implements ApiResponseDto {
}
