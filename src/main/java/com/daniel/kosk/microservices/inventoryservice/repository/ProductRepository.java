package com.daniel.kosk.microservices.inventoryservice.repository;

import com.daniel.kosk.microservices.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategoryId(UUID categoryId);
}
