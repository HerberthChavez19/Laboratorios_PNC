package com.example.ejercicioevaluado03_pnc.exceptions.handler;
import com.example.ejercicioevaluado03_pnc.exceptions.customs.ResourceNotFoundException;
import com.example.ejercicioevaluado03_pnc.exceptions.response.ApiErrorResponse;
import com.example.ejercicioevaluado03_pnc.exceptions.response.FailedValidation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException ex) {
        List<FailedValidation> validationList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FailedValidation(
                        fieldError.getField(),
                        fieldError.getDefaultMessage(),
                        fieldError.getRejectedValue()
                ))
                .toList();
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(Instant.now())
                .message("One or more fields have validation errors")
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation failed")
                .failedValidationList(validationList)
                .build();

        return ResponseEntity.badRequest()
                .body(
                        response
                );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FailedValidation> validationList = ex.getConstraintViolations()
                .stream()
                .map(constraintViolation -> new FailedValidation(
                        constraintViolation.getPropertyPath()
                                .toString(),
                        constraintViolation.getMessage(),
                        constraintViolation.getInvalidValue()
                ))
                .toList();

        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("One or more constraints were violated")
                .error("Constraint violation")
                .failedValidationList(validationList)
                .build();

        return ResponseEntity.badRequest()
                .body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(Instant.now())
                .message(ex.getMessage())
                .error("Resource with specified id was not found")
                .status(HttpStatus.NOT_FOUND.value())
                .failedValidationList(null)
                .build();

        return ResponseEntity.badRequest()
                .body(response);
    }


}

