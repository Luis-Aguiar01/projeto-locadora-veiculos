package com.projeto.locadora.exceptions;

public class InvalidTransmissionException extends RuntimeException {
    public InvalidTransmissionException() {
    }

    public InvalidTransmissionException(String message) {
        super(message);
    }
}
