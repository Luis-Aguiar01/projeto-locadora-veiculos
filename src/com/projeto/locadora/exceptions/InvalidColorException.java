package com.projeto.locadora.exceptions;

public class InvalidColorException extends RuntimeException {
    public InvalidColorException() {
    }

    public InvalidColorException(String message) {
        super(message);
    }
}
