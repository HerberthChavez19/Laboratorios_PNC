package com.example.ejercicioevaluado01_pnc.repository;

import com.example.ejercicioevaluado01_pnc.common.EspecimenList;
import com.example.ejercicioevaluado01_pnc.domain.model.Especimen;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EspecimenRepository {
    private final EspecimenList listaEspecimenes;

    public List<Especimen> findAll(){
        return listaEspecimenes.getAllEspecimenes();
    }
}
