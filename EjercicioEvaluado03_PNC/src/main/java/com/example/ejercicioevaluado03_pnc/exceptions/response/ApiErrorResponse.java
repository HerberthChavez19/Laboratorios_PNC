package com.example.ejercicioevaluado03_pnc.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private Instant timestamp;
    private String message;
    private int status;
    private String error;
    private List<FailedValidation> failedValidationList;
}
