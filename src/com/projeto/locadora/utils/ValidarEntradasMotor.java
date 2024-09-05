package com.projeto.locadora.utils;

import java.time.Year;

public class ValidarEntradasMotor {
    
    private ValidarEntradasMotor() {}
    private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
    private static final ValidadorDouble validadorDouble = ValidadorDouble.getInstance();
    
    public static int validarAnoMotor(String mensagem) {
        boolean condicao = false;
        int ano = 0;
        
        while (!condicao) {
            try {
                ano = validadorInteiro.validar(mensagem);
                
                if (ano > 2014 && ano < Year.now().getValue()) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor valido para o ano do motor.\nIntervalo esperado: Valor maior que 2014 e menor ou igual que " + Year.now().getValue() + ".");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return ano;
    }
    
    public static int validarPotencia(String mensagem) {
        boolean condicao = false;
        int potencia = 0;
        
        while (!condicao) {
            try {
                potencia = validadorInteiro.validar(mensagem);
                
                if (potencia >= 50 && potencia <= 300) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor válido para a potencia do motor.\nIntervalo esperado: Valor maior ou igual a 50 e menor ou igual a 300.");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return potencia;
    }
    
    public static double validarVolumeCilindros(String mensagem) {
        boolean condicao = false;
        double volumeCilindros = 0;
        
        while (!condicao) {
            try {
                volumeCilindros = validadorDouble.validar(mensagem);
                
                if (volumeCilindros >= 1.0 && volumeCilindros <= 3.0) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor válido para o volume dos cilindros do motor.\nIntervalo esperado: Valor maior ou igual a 1.0 e menor ou igual a 3.0");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return volumeCilindros;
    }
    
    public static int validarTorque(String mensagem) {
        boolean condicao = false;
        int torque = 0;
        
        while (!condicao) {
            try {
                torque = validadorInteiro.validar(mensagem);
                
                if (torque >= 10 && torque <= 200) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor válido para o torque do motor.Intervalo esperado: Valor maior ou igual a 10 e menor ou igual a 200");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return torque;
    }
    
    public static int validarNumeroCilindros(String mensagem) {
        boolean condicao = false;
        int numeroCilindros = 0;
        
        while (!condicao) {
            try {
                numeroCilindros = validadorInteiro.validar(mensagem);
                
                if (numeroCilindros == 3 || numeroCilindros == 4 || numeroCilindros == 5 || numeroCilindros == 6) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor válido para o numero de cilindros do motor.\nIntervalo esperado: 3, 4, 5 ou 6 cilindros.");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return numeroCilindros;
    }
    
    public static int validarConsumoCombustivel(String mensagem) {
        boolean condicao = false;
        int consumoCombustivel = 0;
        
        while (!condicao) {
            try {
                consumoCombustivel = validadorInteiro.validar(mensagem);
                
                if (consumoCombustivel >= 3 && consumoCombustivel <= 20) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException("Valor invalido. Por favor, digite um valor valido para o consumo de combustivel do motor.Intervalo esperado: Valor maior ou igual a 3 e menor ou igual a 20");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        
        return consumoCombustivel;
    }
}
