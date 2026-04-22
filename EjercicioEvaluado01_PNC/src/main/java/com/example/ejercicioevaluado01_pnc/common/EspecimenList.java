package com.example.ejercicioevaluado01_pnc.common;

import com.example.ejercicioevaluado01_pnc.domain.model.Especimen;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EspecimenList {
    private final List<Especimen> especimenes;

    public EspecimenList() {
        this.especimenes = new ArrayList<>();

        this.especimenes.add(Especimen.builder()
                .id(1L).nombre("Licker").virusBase("T-Virus")
                .nivelPeligrosidad(4).puntoDebil("Cabeza")
                .estadoActual("En libertad").ultUbicacion("Comisaría")
                .posibleRebrotes("Lab Redes").build());

        this.especimenes.add(Especimen.builder()
                .id(2L).nombre("Hunter").virusBase("T-Virus")
                .nivelPeligrosidad(3).puntoDebil("Cuello")
                .estadoActual("Contenido").ultUbicacion("Mansión")
                .posibleRebrotes("Lab Programación").build());

        this.especimenes.add(Especimen.builder()
                .id(3L).nombre("Cerberus").virusBase("T-Virus")
                .nivelPeligrosidad(2).puntoDebil("Espina dorsal")
                .estadoActual("En libertad").ultUbicacion("Laboratorio")
                .posibleRebrotes("Lab Redes").build());

        this.especimenes.add(Especimen.builder()
                .id(4L).nombre("Tyrant").virusBase("G-Virus")
                .nivelPeligrosidad(5).puntoDebil("Corazón expuesto")
                .estadoActual("En libertad").ultUbicacion("Laboratorio")
                .posibleRebrotes("Lab Base de Datos").build());

        this.especimenes.add(Especimen.builder()
                .id(5L).nombre("William Birkin").virusBase("G-Virus")
                .nivelPeligrosidad(5).puntoDebil("Ojos mutados")
                .estadoActual("Eliminado").ultUbicacion("Laboratorio")
                .posibleRebrotes("Lab Química").build());

        this.especimenes.add(Especimen.builder()
                .id(6L).nombre("Regenerator").virusBase("Las Plagas")
                .nivelPeligrosidad(4).puntoDebil("Parásitos internos")
                .estadoActual("Contenido").ultUbicacion("Pueblo")
                .posibleRebrotes("Lab Electrónica").build());

        this.especimenes.add(Especimen.builder()
                .id(7L).nombre("Ganado").virusBase("Las Plagas")
                .nivelPeligrosidad(2).puntoDebil("Cabeza")
                .estadoActual("En libertad").ultUbicacion("Pueblo")
                .posibleRebrotes("Lab Electrónica").build());

        this.especimenes.add(Especimen.builder()
                .id(8L).nombre("Lady Dimitrescu").virusBase("Cadou")
                .nivelPeligrosidad(4).puntoDebil("Sangre fría")
                .estadoActual("Contenido").ultUbicacion("Castillo")
                .posibleRebrotes("Lab Arquitectura").build());

        this.especimenes.add(Especimen.builder()
                .id(9L).nombre("Heisenberg").virusBase("Cadou")
                .nivelPeligrosidad(5).puntoDebil("Campo electromagnético")
                .estadoActual("En libertad").ultUbicacion("Fábrica")
                .posibleRebrotes("Lab Física").build());

        this.especimenes.add(Especimen.builder()
                .id(10L).nombre("Moreau").virusBase("Cadou")
                .nivelPeligrosidad(3).puntoDebil("Forma inestable")
                .estadoActual("Eliminado").ultUbicacion("Embalse")
                .posibleRebrotes("Lab Biología").build());

        this.especimenes.add(Especimen.builder()
                .id(11L).nombre("Nemesis").virusBase("T-Virus")
                .nivelPeligrosidad(5).puntoDebil("Sistema nervioso")
                .estadoActual("En libertad").ultUbicacion("Ciudad")
                .posibleRebrotes("Lab Seguridad").build());

        this.especimenes.add(Especimen.builder()
                .id(12L).nombre("Bandersnatch").virusBase("T-Virus")
                .nivelPeligrosidad(3).puntoDebil("Brazo mutado")
                .estadoActual("Contenido").ultUbicacion("Base militar")
                .posibleRebrotes("Lab Mecánica").build());
    }

    public List<Especimen> getAllEspecimenes() {
        return especimenes;
    }


}
