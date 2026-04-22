package com.example.ejercicioevaluado01_pnc;

import com.example.ejercicioevaluado01_pnc.services.EspecimenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioEvaluado01PncApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioEvaluado01PncApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EspecimenService especimenService) {

        return args -> {

            System.out.println("=== [S.T.A.R.S-REPORT] FILTRO POR VIRUS (T-Virus) ===");
            especimenService.findByVirusBase("T-Virus")
                    .forEach(e ->
                            System.out.println("[S.T.A.R.S-REPORT] Nombre: " + e.getNombre()
                                    + " | Nivel de Peligro: " + e.getNivelPeligrosidad()
                                    + " | Punto Débil: " + e.getPuntoDebil())
                    );

            System.out.println("\n=== [S.T.A.R.S-REPORT] FILTRO POR ESTADO (En libertad) ===");
            especimenService.findByEstadoActual("En libertad")
                    .forEach(e ->
                            System.out.println("[S.T.A.R.S-REPORT] Nombre: " + e.getNombre()
                                    + " | Nivel de Peligro: " + e.getNivelPeligrosidad()
                                    + " | Punto Débil: " + e.getPuntoDebil())
                    );

            System.out.println("\n=== [S.T.A.R.S-REPORT] VIRUS ACTIVOS (SIN REPETICIÓN) ===");
            especimenService.findVirusActivosUnicos()
                    .forEach(v ->
                            System.out.println("[S.T.A.R.S-REPORT] Virus activo: " + v)
                    );
        };
    }

}
