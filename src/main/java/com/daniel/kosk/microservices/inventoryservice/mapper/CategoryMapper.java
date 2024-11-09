package com.daniel.kosk.microservices.inventoryservice.mapper;

import com.daniel.kosk.microservices.inventoryservice.dto.CategoryDto;
import com.daniel.kosk.microservices.inventoryservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id",ignore = true)
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

}
