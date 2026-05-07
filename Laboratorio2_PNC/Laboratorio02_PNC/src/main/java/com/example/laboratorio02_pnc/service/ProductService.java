package com.example.laboratorio02_pnc.service;

import com.example.laboratorio02_pnc.domain.entity.Product;

import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    Product getProduct(String name);
    void updateProduct(UUID id, Product product);
}



