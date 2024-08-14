package com.projeto.locadora.exceptions;

public class CargoAlreadyRegisteredException extends RuntimeException {
    public CargoAlreadyRegisteredException() {
        super();
    }

    public CargoAlreadyRegisteredException(String message) {
        super(message);
    }
}
