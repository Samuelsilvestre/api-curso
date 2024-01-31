package com.api.course.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.course.exception.GenericException;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundException(GenericException exception) {
        return exception.getMessage();
    }
}
