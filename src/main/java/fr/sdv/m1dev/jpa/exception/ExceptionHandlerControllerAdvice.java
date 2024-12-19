package fr.sdv.m1dev.jpa.exception;

import fr.sdv.m1dev.jpa.exception.EntityToCreateHasAnIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import fr.sdv.m1dev.jpa.exception.ErrorDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler({jakarta.persistence.EntityNotFoundException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleExceptionNotFound(Exception exception, WebRequest request) {
        exception.printStackTrace();
        return new ErrorDto(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler({EntityToCreateHasAnIdException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleEntityToCreateHasAnIdException(Exception exception, WebRequest request) {
        exception.printStackTrace();
        return new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler({EntityToUpdateHasNoIdException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleEntityToUpdateHasNoIdException(Exception exception, WebRequest request) {
        exception.printStackTrace();
        return new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public InvalidEntityErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        // Collecter les erreurs de validation
        List<InvalidEntityErrorDto.FieldError> fieldErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new InvalidEntityErrorDto.FieldError(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        // Construire et renvoyer le DTO
        return new InvalidEntityErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                "Validation echoué",
                fieldErrors
        );
    }
}
