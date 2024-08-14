package com.projeto.locadora.exceptions;

public class AlreadyRegisteredUserException extends RuntimeException {
    public AlreadyRegisteredUserException() {
        super();
    }

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }
}
