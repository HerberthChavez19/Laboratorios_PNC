package com.example.laboratorio02_pnc.repository;

import com.example.laboratorio02_pnc.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product getProductsByName(String name);

    Product getProductsById(UUID id);
}