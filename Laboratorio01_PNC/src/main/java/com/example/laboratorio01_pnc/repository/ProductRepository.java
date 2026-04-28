package com.example.laboratorio01_pnc.repository;

import com.example.laboratorio01_pnc.common.ProductList;
import com.example.laboratorio01_pnc.domain.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final ProductList listaProductos;

    public List<Producto> findAll(){
        return listaProductos.getProducts();
    }

}
