package com.projeto.locadora.utils;

import java.time.Year;
import java.util.Scanner;

public class ValidarEntradasMotor {
    private static final Scanner scanner = new Scanner(System.in);
    
    private ValidarEntradasMotor() {}
    
    public static int validarAnoMotor(String mensagem) {
        boolean condicao = false;
        int ano = 0;
        
        while (!condicao) {
            try {
                System.out.println(mensagem);
                ano = scanner.nextInt();
                
                if (ano > 2000 && ano < Year.now().getValue()) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o ano do motor.");
            }
        }
        
        return ano;
    }
}
