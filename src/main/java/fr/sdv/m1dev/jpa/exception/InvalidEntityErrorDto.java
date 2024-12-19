package fr.sdv.m1dev.jpa.exception;

import java.time.LocalDateTime;
import java.util.List;

public class InvalidEntityErrorDto {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private List<FieldError> errors;

    public InvalidEntityErrorDto(int status, LocalDateTime timestamp, String message, List<FieldError> errors) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }

    // Getters et setters

    public static class FieldError {
        private String field;
        private String errorMessage;

        public FieldError(String field, String errorMessage) {
            this.field = field;
            this.errorMessage = errorMessage;
        }

        // Getters et setters
    }
}
