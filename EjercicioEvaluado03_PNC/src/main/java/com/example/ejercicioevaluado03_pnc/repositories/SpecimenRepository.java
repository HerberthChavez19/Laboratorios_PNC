package com.example.ejercicioevaluado03_pnc.repositories;

import com.example.ejercicioevaluado03_pnc.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
}
