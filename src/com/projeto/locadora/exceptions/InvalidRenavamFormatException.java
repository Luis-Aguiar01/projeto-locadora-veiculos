package com.projeto.locadora.exceptions;

public class InvalidRenavamFormatException extends RuntimeException {
    public InvalidRenavamFormatException() {
    }

    public InvalidRenavamFormatException(String message) {
        super(message);
    }
}
