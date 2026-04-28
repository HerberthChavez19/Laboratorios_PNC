package com.example.laboratorio01_pnc.common;

import com.example.laboratorio01_pnc.domain.model.Producto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductList {
    private final List<Producto> products;

    public ProductList() {
        this.products = new ArrayList<>();

        this.products.add(Producto.builder()
                .id(1L)
                .nombre("Laptop")
                .precio(850.50)
                .build());

        this.products.add(Producto.builder()
                .id(2L)
                .nombre("Mouse")
                .precio(19.99)
                .build());

        this.products.add(Producto.builder()
                .id(3L)
                .nombre("Teclado")
                .precio(45.00)
                .build());

        this.products.add(Producto.builder()
                .id(4L)
                .nombre("Monitor")
                .precio(199.90)
                .build());
    }

    public List<Producto> getProducts() {
        return products;
    }
}
