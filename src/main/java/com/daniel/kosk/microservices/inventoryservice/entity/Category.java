package com.daniel.kosk.microservices.inventoryservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Product> products;

}
