package com.daniel.kosk.microservices.inventoryservice.mapper;

import com.daniel.kosk.microservices.inventoryservice.dto.ProductDto;
import com.daniel.kosk.microservices.inventoryservice.entity.Category;
import com.daniel.kosk.microservices.inventoryservice.entity.Product;
import com.daniel.kosk.microservices.inventoryservice.repository.CategoryRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);
}
