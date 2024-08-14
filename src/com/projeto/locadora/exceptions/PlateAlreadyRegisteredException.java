package com.projeto.locadora.exceptions;

public class PlateAlreadyRegisteredException extends RuntimeException {
    public PlateAlreadyRegisteredException() {
        super();
    }

    public PlateAlreadyRegisteredException(String message) {
        super(message);
    }
}
