package com.springboot.springdemo.hw2.controller;

import com.springboot.springdemo.hw2.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> handleNotValidException(MethodArgumentNotValidException exception) {
        //String details = exception.getMessage();
        String details = exception.getFieldError().getDefaultMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDTO.builder()
                        .timestamp(System.currentTimeMillis())
                        .details(details)
                        .build());
    }
}
