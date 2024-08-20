package com.projeto.locadora.exceptions;

public class MinimumAgeRequirementException extends RuntimeException{
    
    public MinimumAgeRequirementException() {
        super();
    }

    public MinimumAgeRequirementException(String message) {
        super(message);
    }
    
}
