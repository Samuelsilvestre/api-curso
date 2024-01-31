package com.api.course.exception;

public class GenericException extends RuntimeException{
    
    
    public GenericException(Long id) {
        super("dado não encontrado" + id);
    }
}
