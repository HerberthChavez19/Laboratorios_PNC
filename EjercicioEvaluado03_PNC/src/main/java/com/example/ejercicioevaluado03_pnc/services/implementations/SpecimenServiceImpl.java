package com.example.ejercicioevaluado03_pnc.services.implementations;

import com.example.ejercicioevaluado03_pnc.common.SpecimenMapper;
import com.example.ejercicioevaluado03_pnc.dto.request.CreateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.request.UpdateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.response.PageableResponse;
import com.example.ejercicioevaluado03_pnc.dto.response.SpecimenResponse;
import com.example.ejercicioevaluado03_pnc.exceptions.customs.ResourceNotFoundException;
import com.example.ejercicioevaluado03_pnc.model.Specimen;
import com.example.ejercicioevaluado03_pnc.repositories.SpecimenRepository;
import com.example.ejercicioevaluado03_pnc.services.SpecimenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return specimenMapper.toDto(
                specimenRepository.save(specimenMapper.toEntityCreate(request))
        );
    }

    @Override
    public PageableResponse<SpecimenResponse> getAllSpecimens(
            Integer page,
            Integer size,
            String sortBy,
            String sortOrder
    ) {
        Sort sort = sortOrder.equalsIgnoreCase("desc")
                ? Sort.by(sortBy)
                  .descending()
                : Sort.by(sortBy)
                  .ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Specimen> specimenPage = specimenRepository.findAll(pageable);

        if (specimenPage.isEmpty()) {
            throw new ResourceNotFoundException("No specimens are registered in Hyrule");
        }

        return specimenMapper.toPageableResponse(specimenPage);
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return specimenMapper.toDto(specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Sheikah Slate records"))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id);
        return specimenMapper.toDto(specimenRepository.save(specimenMapper.toEntityUpdate(request, id)));
    }

    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existSpecimen = this.getSpecimenById(id);
        specimenRepository.deleteById(id);
        return existSpecimen;
    }
}

