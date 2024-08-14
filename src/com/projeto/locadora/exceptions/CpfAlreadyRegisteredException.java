package com.projeto.locadora.exceptions;

public class CpfAlreadyRegisteredException extends RuntimeException {
    public CpfAlreadyRegisteredException() {
        super();
    }

    public CpfAlreadyRegisteredException(String message) {
        super(message);
    }
}