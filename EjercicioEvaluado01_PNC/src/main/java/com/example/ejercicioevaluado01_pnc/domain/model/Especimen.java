package com.example.ejercicioevaluado01_pnc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Especimen {
    private long id;
    private String virusBase;
    private String nombre;
    private int nivelPeligrosidad;
    private String puntoDebil;
    private String estadoActual;
    private String ultUbicacion;
    private String posibleRebrotes;
}
