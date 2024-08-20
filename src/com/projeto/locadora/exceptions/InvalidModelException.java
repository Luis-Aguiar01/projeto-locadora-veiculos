package com.projeto.locadora.exceptions;

public class InvalidModelException extends RuntimeException {
    public InvalidModelException() {
    }

    public InvalidModelException(String message) {
        super(message);
    }
}
