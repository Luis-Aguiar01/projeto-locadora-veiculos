package com.projeto.locadora.exceptions;

public class NumberOutOfRangeException extends RuntimeException 
{
    public NumberOutOfRangeException() {
        super();
    }

    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
