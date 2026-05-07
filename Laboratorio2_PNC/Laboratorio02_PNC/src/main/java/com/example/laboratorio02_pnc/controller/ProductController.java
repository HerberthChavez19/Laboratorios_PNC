package com.example.laboratorio02_pnc.controller;

import com.example.laboratorio02_pnc.domain.entity.Product;
import com.example.laboratorio02_pnc.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping("/getProduct/{name}")
    public ResponseEntity<Product> getProduct(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProduct(name));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable UUID id,
            @RequestBody Product product
    ) {
        productService.updateProduct(id, product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(product);
    }
}