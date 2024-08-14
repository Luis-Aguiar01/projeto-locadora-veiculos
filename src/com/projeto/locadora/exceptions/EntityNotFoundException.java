package com.projeto.locadora.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super();
    }
    
    public EntityNotFoundException(String message) {
        super(message);
    }
}
