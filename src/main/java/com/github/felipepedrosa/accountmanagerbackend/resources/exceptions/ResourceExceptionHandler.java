package com.github.felipepedrosa.accountmanagerbackend.resources.exceptions;

import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.ResourceNotFoundException;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // Controller advice is used to intercept errors.
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleError(ResourceNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Resource not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}