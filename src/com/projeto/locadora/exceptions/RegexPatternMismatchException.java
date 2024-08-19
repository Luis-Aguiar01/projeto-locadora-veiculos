package com.projeto.locadora.exceptions;

public class RegexPatternMismatchException extends RuntimeException
{
    public RegexPatternMismatchException() {
        super();
    }

    public RegexPatternMismatchException(String message) {
        super(message);
    }
}
