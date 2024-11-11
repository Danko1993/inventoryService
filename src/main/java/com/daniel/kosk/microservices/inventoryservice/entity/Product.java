package com.daniel.kosk.microservices.inventoryservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    private UUID id=UUID.randomUUID();
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",nullable = false)
    @JsonBackReference
    private Category category;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int stockQuantity;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false, unique = true)
    private String producerCode;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String currency;
}
