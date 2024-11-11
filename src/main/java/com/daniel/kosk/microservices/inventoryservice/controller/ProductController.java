package com.daniel.kosk.microservices.inventoryservice.controller;

import com.daniel.kosk.microservices.inventoryservice.dto.ApiResponseDto;
import com.daniel.kosk.microservices.inventoryservice.dto.ProductDto;
import com.daniel.kosk.microservices.inventoryservice.dto.ResponseDto;
import com.daniel.kosk.microservices.inventoryservice.service.ProductService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@Slf4j
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

    @PostMapping(value ="/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponseDto>
    addProduct(@RequestPart("file") MultipartFile file,
               @RequestPart("data") @Valid ProductDto productDto,
               BindingResult result) {
        log.info("Starting adding product");
        if (result.hasErrors() && result != null) {
            log.error(result.getAllErrors().toString());
            return returnValidationErrors(result);
        }
        if (file.isEmpty()){
            log.error("File is empty");
            return new ResponseEntity<>(new ResponseDto("File not sent."),HttpStatus.BAD_REQUEST);
        }
        try {
            

            return productService.addProduct(productDto,file);
        }catch (ExpiredJwtException e){
            log.error("Expired JWT token", e);
            return new ResponseEntity<>(new ResponseDto("JWT expired."),HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponseDto(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public ResponseEntity<ApiResponseDto> returnValidationErrors(BindingResult result) {
        String validationErrors = result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        log.error("Validation errors: " + validationErrors);
        return new ResponseEntity<>( new ResponseDto("Validating erros: " + validationErrors), HttpStatus.BAD_REQUEST);
    }

}
