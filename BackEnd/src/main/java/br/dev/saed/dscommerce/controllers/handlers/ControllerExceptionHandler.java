package br.dev.saed.dscommerce.controllers.handlers;

import br.dev.saed.dscommerce.dto.CustomError;
import br.dev.saed.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // Anotação para tratar exceções nas camadas de controle
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) // Anotação para tratar exceções do tipo ResourceNotFoundException
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(request.getRequestURI(), e.getMessage(), Instant.now(), status.value());
        return ResponseEntity.status(status).body(error);
    }
}
