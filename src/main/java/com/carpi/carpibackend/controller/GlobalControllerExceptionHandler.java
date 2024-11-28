package com.carpi.carpibackend.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleNoHandlerFoundException(HttpServletRequest request) {
        return new ResponseEntity<>(
                new ExceptionResponseBody("Resource not found", request.getRequestURI()),
                HttpStatus.NOT_FOUND
        );
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseBody> handleException(HttpServletRequest request) {
        return new ResponseEntity<>(
                new ExceptionResponseBody("Internal server error", request.getRequestURI()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @Getter
    private class ExceptionResponseBody {

        private Date timestamp;
        private String message;
        private String path;

        public ExceptionResponseBody(String message, String path) {
            this.timestamp = new Date();
            this.message = message;
            this.path = path;
        }
    }
}
