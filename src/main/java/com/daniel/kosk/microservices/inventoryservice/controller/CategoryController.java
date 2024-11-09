package com.daniel.kosk.microservices.inventoryservice.controller;

import com.daniel.kosk.microservices.inventoryservice.dto.ApiResponseDto;
import com.daniel.kosk.microservices.inventoryservice.dto.ResponseDto;
import com.daniel.kosk.microservices.inventoryservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/get-all")
    public ResponseEntity<List<? extends ApiResponseDto>> getAllCategories(){
        try {
            return categoryService.getAllCategories();
        }catch (Exception e){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
