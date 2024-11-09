package com.daniel.kosk.microservices.inventoryservice.service;

import com.daniel.kosk.microservices.inventoryservice.dto.ApiResponseDto;
import com.daniel.kosk.microservices.inventoryservice.dto.ProductDto;
import com.daniel.kosk.microservices.inventoryservice.entity.Product;
import com.daniel.kosk.microservices.inventoryservice.mapper.ProductMapper;
import com.daniel.kosk.microservices.inventoryservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public ResponseEntity<List<? extends ApiResponseDto>> getAllProducts() {
        List< ProductDto> products = productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());

        log.info("Fetched {} products", products.size());

        if (products.isEmpty()) {
            log.warn("No products found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<List<? extends ApiResponseDto>> getProductsByCategoryId(UUID categoryId) {
        List<Product> allProducts = productRepository.findAll();
        log.info("Fetched {} products from database", allProducts.size());

        List<ProductDto> result = allProducts.stream()
                .filter(product -> {
                    log.info("Checking product with ID: {}, Category ID: {}", product.getId(), product.getCategory().getId());
                    return product.getCategory().getId().equals(categoryId);
                })
                .map(productMapper::toDto)
                .collect(Collectors.toList());

        log.info("Filtered {} products for category ID: {}", result.size(), categoryId);

        if (result.isEmpty()) {
            log.warn("No products found for category ID: {}", categoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }




}
