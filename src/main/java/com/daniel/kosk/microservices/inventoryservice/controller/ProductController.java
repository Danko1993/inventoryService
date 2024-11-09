package com.daniel.kosk.microservices.inventoryservice.controller;

import com.daniel.kosk.microservices.inventoryservice.dto.ApiResponseDto;
import com.daniel.kosk.microservices.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<? extends ApiResponseDto>> getAllProducts() {
        try {
            return productService.getAllProducts();
        }catch (Exception e){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-by-category")
    public ResponseEntity<List<? extends ApiResponseDto>> getProductsByCategoryId(@RequestParam UUID categoryId) {
        try {
            return productService.getProductsByCategoryId(categoryId);
        }catch (Exception e){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
