package fr.sdv.m1dev.jpa.exception;

import java.time.LocalDateTime;

public class ErrorDto {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDto(int status, LocalDateTime timestamp, String message, String details) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // Getters et setters
}