package com.projeto.locadora.exceptions;

public class InvalidEstadoVeiculoException extends RuntimeException {
    public InvalidEstadoVeiculoException() {
    }

    public InvalidEstadoVeiculoException(String message) {
        super(message);
    }
}
