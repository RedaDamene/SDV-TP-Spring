package fr.sdv.m1dev.jpa.exception;

public class EntityToUpdateHasNoIdException extends RuntimeException {
    public EntityToUpdateHasNoIdException(String message) {
        super(message);
    }
}