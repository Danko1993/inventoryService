package com.daniel.kosk.microservices.inventoryservice.mapper;

import com.daniel.kosk.microservices.inventoryservice.dto.ProductDto;
import com.daniel.kosk.microservices.inventoryservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "id",ignore = true)
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);
}
