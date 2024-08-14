package com.projeto.locadora.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {
    public EmailAlreadyRegisteredException() {
        super();
    }

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}