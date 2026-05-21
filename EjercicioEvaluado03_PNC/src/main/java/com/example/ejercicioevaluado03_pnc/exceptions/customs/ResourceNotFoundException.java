package com.example.ejercicioevaluado03_pnc.exceptions.customs;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}