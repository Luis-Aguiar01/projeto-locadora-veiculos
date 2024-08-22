package com.projeto.locadora.exceptions;

public class InvalidDisponibilidadeVeiculoException extends RuntimeException {
    public InvalidDisponibilidadeVeiculoException() {
    }

    public InvalidDisponibilidadeVeiculoException(String message) {
        super(message);
    }
}
