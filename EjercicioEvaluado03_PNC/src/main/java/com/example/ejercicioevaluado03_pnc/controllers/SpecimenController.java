package com.example.ejercicioevaluado03_pnc.controllers;

import com.example.ejercicioevaluado03_pnc.dto.GeneralResponse;
import com.example.ejercicioevaluado03_pnc.dto.request.CreateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.services.SpecimenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SpecimenController {
    private final SpecimenService specimenService;

    @PostMapping("/specimen")
    public ResponseEntity<GeneralResponse> createSpecimen(@Valid @RequestBody CreateSpecimenRequest request) {
        return buildResponse(
                "Specimen created successfully",
                HttpStatus.CREATED,
                specimenService.createSpecimen(request)
        );
    }

    @GetMapping("/specimens")
    public ResponseEntity<GeneralResponse> listAllSpecimens(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return buildResponse(
                "Specimens retrieved successfully",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder)
        );
    }

    @GetMapping("/{id}/specimen")
    public ResponseEntity<GeneralResponse> listOneSpecimen(@PathVariable UUID id) {
        return buildResponse(
                "Specimen retrieved successfully",
                HttpStatus.OK,
                specimenService.getSpecimenById(id)
        );
    }

    //Method to generate a general response
    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .build()
                .getPath();

        return ResponseEntity.status(status)
                .body(
                        GeneralResponse.builder()
                                .uri(uri)
                                .message(message)
                                .status(status.value())
                                .time(LocalDateTime.now())
                                .data(data)
                                .build()
                );


    }
}
