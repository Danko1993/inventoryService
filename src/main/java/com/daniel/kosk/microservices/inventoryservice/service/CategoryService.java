package com.daniel.kosk.microservices.inventoryservice.service;

import com.daniel.kosk.microservices.inventoryservice.dto.ApiResponseDto;
import com.daniel.kosk.microservices.inventoryservice.dto.CategoryDto;
import com.daniel.kosk.microservices.inventoryservice.mapper.CategoryMapper;
import com.daniel.kosk.microservices.inventoryservice.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public ResponseEntity<List<? extends ApiResponseDto>> getAllCategories() {
        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());

        log.info("Fetched {} categories", categories.size());

        if (categories.isEmpty()) {
            log.warn("No categories found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
