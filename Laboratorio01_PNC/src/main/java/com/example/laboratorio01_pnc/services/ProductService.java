package com.example.laboratorio01_pnc.services;
import com.example.laboratorio01_pnc.common.ProductList;
import com.example.laboratorio01_pnc.domain.model.Producto;
import com.example.laboratorio01_pnc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepository productRepository;

    public List<Producto> findAll(){
        return productRepository.findAll();
    }
}


