package com.example.laboratorio01_pnc;

import com.example.laboratorio01_pnc.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Laboratorio01PncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio01PncApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductService productService) {

        return args -> {

            System.out.println("=== INICIANDO APP ===");
            productService.findAll().forEach(p ->
                    System.out.println(p.getNombre() + " - $" + p.getPrecio())
            );
        };
    }

}
