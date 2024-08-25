package com.projeto.locadora.exceptions;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
