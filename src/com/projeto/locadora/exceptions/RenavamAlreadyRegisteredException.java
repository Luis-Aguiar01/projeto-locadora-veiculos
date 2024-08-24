package com.projeto.locadora.exceptions;

public class RenavamAlreadyRegisteredException extends RuntimeException {
    public RenavamAlreadyRegisteredException() {
    }

    public RenavamAlreadyRegisteredException(String message) {
        super(message);
    }
}
