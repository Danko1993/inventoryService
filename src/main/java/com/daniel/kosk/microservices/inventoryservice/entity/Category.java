package com.daniel.kosk.microservices.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Category {

    @Id
    private UUID id=UUID.randomUUID();
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
