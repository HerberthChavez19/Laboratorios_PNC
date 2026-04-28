package com.example.laboratorio01_pnc.domain.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private long id;
    private String nombre;
    private double precio;
}
