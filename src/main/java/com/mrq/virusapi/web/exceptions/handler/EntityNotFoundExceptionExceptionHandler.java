package com.mrq.virusapi.web.exceptions.handler;

import com.mrq.virusapi.web.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityNotFoundExceptionExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String ERROR_MESSAGE = "entity not found";
    @ExceptionHandler(value
            = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ERROR_MESSAGE,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}