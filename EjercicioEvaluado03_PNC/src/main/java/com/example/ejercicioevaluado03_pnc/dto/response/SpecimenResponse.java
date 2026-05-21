package com.example.ejercicioevaluado03_pnc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecimenResponse {
    private UUID id;
    private String name;
    private String region;
    private Integer dangerLevel;
    private Boolean isFriendly;
}
