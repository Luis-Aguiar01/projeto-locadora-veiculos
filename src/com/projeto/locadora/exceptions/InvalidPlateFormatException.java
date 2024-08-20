package com.projeto.locadora.exceptions;

public class InvalidPlateFormatException extends RuntimeException {
    public InvalidPlateFormatException() {
    }

    public InvalidPlateFormatException(String message) {
        super(message);
    }
}
