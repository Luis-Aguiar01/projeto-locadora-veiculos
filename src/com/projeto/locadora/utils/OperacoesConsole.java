package com.projeto.locadora.utils;

public class OperacoesConsole {
    
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    
    private OperacoesConsole() {}
    
    public static void limparConsole() {
        for (int i = 0; i < 5; i++) 
        {
            System.out.println();
        }
    }
}
