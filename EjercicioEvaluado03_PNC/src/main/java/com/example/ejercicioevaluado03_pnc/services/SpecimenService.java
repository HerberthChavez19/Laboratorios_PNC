package com.example.ejercicioevaluado03_pnc.services;

import com.example.ejercicioevaluado03_pnc.dto.request.CreateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.request.UpdateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.response.PageableResponse;
import com.example.ejercicioevaluado03_pnc.dto.response.SpecimenResponse;

import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    PageableResponse<SpecimenResponse> getAllSpecimens(
            Integer page,
            Integer size,
            String sortBy,
            String sortOrder
    );

    SpecimenResponse getSpecimenById(UUID id);

    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    SpecimenResponse deleteSpecimen(UUID id);
}
