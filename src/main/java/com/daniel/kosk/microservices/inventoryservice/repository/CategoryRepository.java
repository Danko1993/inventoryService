package com.daniel.kosk.microservices.inventoryservice.repository;

import com.daniel.kosk.microservices.inventoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String categoryName);
}
