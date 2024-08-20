package com.projeto.locadora.exceptions;

public class InvalidValueOfValorDiariaException  extends RuntimeException{
    public InvalidValueOfValorDiariaException() {
    }

    public InvalidValueOfValorDiariaException(String message) {
        super(message);
    }
}
