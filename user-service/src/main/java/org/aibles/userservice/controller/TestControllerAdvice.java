package org.aibles.userservice.controller;

import org.aibles.userservice.service.exception.AbstractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestControllerAdvice {
    @ExceptionHandler(value={AbstractException.class})
    public ResponseEntity<String> handleException(AbstractException ex){
        return new ResponseEntity<>(ex.getMessage(),ex.getStatus());
    }
}
