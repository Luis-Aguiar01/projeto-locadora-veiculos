package com.projeto.locadora.utils;

import java.time.Year;

public class ValidarEntradasMotor {
    
    private ValidarEntradasMotor() {}
    
    public static int validarAnoMotor(String mensagem) {
        boolean condicao = false;
        int ano = 0;
        
        while (!condicao) {
            try {
                ano = ValidarEntradas.validarEntradaInteira(mensagem);
                
                if (ano > 2014 && ano < Year.now().getValue()) {
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
    
    public static int validarPotencia(String mensagem) {
        boolean condicao = false;
        int potencia = 0;
        
        while (!condicao) {
            try {
                potencia = ValidarEntradas.validarEntradaInteira(mensagem);
                
                if (potencia >= 50 && potencia <= 300) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para a potencia do motor.");
            }
        }
        
        return potencia;
    }
    
    public static double validarVolumeCilindros(String mensagem) {
        boolean condicao = false;
        double volumeCilindros = 0;
        
        while (!condicao) {
            try {
                volumeCilindros = ValidarEntradas.validarEntradaDouble(mensagem);
                
                if (volumeCilindros >= 1.0 && volumeCilindros <= 3.0) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o volume dos cilindros do motor.");
            }
        }
        
        return volumeCilindros;
    }
    
    public static int validarTorque(String mensagem) {
        boolean condicao = false;
        int torque = 0;
        
        while (!condicao) {
            try {
                torque = ValidarEntradas.validarEntradaInteira(mensagem);
                
                if (torque >= 100 && torque <= 300) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o torque do motor.");
            }
        }
        
        return torque;
    }
    
    public static int validarNumeroCilindros(String mensagem) {
        boolean condicao = false;
        int numeroCilindros = 0;
        
        while (!condicao) {
            try {
                numeroCilindros = ValidarEntradas.validarEntradaInteira(mensagem);
                
                if (numeroCilindros == 3 || numeroCilindros == 4 || numeroCilindros == 5 || numeroCilindros == 6) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o numero de cilindros do motor.");
            }
        }
        
        return numeroCilindros;
    }
    
    public static int validarConsumoCombustivel(String mensagem) {
        boolean condicao = false;
        int consumoCombustivel = 0;
        
        while (!condicao) {
            try {
                consumoCombustivel = ValidarEntradas.validarEntradaInteira(mensagem);
                
                if (consumoCombustivel >= 3 && consumoCombustivel <= 20) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o consumo de combustivel do motor.");
            }
        }
        
        return consumoCombustivel;
    }
}
