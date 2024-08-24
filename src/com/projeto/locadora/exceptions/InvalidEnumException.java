package com.projeto.locadora.exceptions;

public class InvalidEnumException extends RuntimeException {
    public InvalidEnumException() {
    }

    public InvalidEnumException(String message) {
        super(message);
    }
}
