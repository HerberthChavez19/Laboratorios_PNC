package com.example.ejercicioevaluado03_pnc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSpecimenRequest {
    private String name;
    private String region;
    private Integer dangerLevel;
    private Boolean isFriendly;
}
