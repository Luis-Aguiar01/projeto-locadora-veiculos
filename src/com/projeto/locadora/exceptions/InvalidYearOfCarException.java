package com.projeto.locadora.exceptions;

public class InvalidYearOfCarException extends RuntimeException {
    public InvalidYearOfCarException() {
    }

    public InvalidYearOfCarException(String message) {
        super(message);
    }
}
