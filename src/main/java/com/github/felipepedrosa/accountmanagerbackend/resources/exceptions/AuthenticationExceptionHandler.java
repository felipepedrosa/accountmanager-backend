package com.github.felipepedrosa.accountmanagerbackend.resources.exceptions;


import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.AuthenticationException;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.ResourceNotFoundException;
import com.github.felipepedrosa.accountmanagerbackend.services.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // Controller advice is used to intercept errors.
public class AuthenticationExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<StandardError> handleError(AuthenticationException ex, HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), HttpStatus.UNAUTHORIZED.value(), "Invalid credentials",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}