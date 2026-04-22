package com.example.ejercicioevaluado01_pnc.services;

import com.example.ejercicioevaluado01_pnc.domain.model.Especimen;
import com.example.ejercicioevaluado01_pnc.repository.EspecimenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecimenService {

    private final EspecimenRepository especimenRepository;

    public List<Especimen> findAll() {
        return especimenRepository.findAll();
    }

    public List<Especimen> findByVirusBase(String virus) {
        return especimenRepository.findAll()
                .stream()
                .filter(e -> e.getVirusBase().equalsIgnoreCase(virus))
                .toList();
    }

    public List<Especimen> findByEstadoActual(String estado) {
        return especimenRepository.findAll()
                .stream()
                .filter(e -> e.getEstadoActual().equalsIgnoreCase(estado))
                .toList();
    }

    public List<String> findVirusActivosUnicos() {
        return especimenRepository.findAll()
                .stream()
                .filter(e -> e.getEstadoActual().equalsIgnoreCase("En libertad"))
                .map(Especimen::getVirusBase)
                .distinct()
                .toList();
    }
}