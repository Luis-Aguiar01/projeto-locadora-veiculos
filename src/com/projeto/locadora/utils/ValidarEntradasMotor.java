package com.projeto.locadora.utils;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidarEntradasMotor {
    private static final Scanner scanner = SingletonScanner.getInstance();
    
    private ValidarEntradasMotor() {}
    
    public static int validarAnoMotor(String mensagem) {
        boolean condicao = false;
        int ano = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                ano = scanner.nextInt();
                
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
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite um numero inteiro.");
                scanner.nextLine();
            }
        }
        
        return ano;
    }
    
    public static int validarPotencia(String mensagem) {
        boolean condicao = false;
        int potencia = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                potencia = scanner.nextInt();
                
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
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite um numero inteiro.");
                scanner.nextLine();
            }
        }
        
        return potencia;
    }
    
    public static double validarVolumeCilindros(String mensagem) {
        boolean condicao = false;
        double volumeCilindros = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                volumeCilindros = scanner.nextDouble();
                
                if (volumeCilindros >= 1.0 && volumeCilindros <= 2.5) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o volume dos cilindros do motor.");
            }
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite apenas numeros.");
                scanner.nextLine();
            }
        }
        
        return volumeCilindros;
    }
    
    public static int validarTorque(String mensagem) {
        boolean condicao = false;
        int torque = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                torque = scanner.nextInt();
                
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
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite apenas numeros.");
                scanner.nextLine();
            }
        }
        
        return torque;
    }
    
    public static int validarNumeroCilindros(String mensagem) {
        boolean condicao = false;
        int numeroCilindros = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                numeroCilindros = scanner.nextInt();
                
                if (numeroCilindros == 3 || numeroCilindros == 4 || numeroCilindros == 6) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o numero de cilindros do motor.");
            }
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite apenas numeros.");
                scanner.nextLine();
            }
        }
        
        return numeroCilindros;
    }
    
    public static int validarConsumoCombustivel(String mensagem) {
        boolean condicao = false;
        int consumoCombustivel = 0;
        
        while (!condicao) {
            try {
                System.out.print(mensagem);
                consumoCombustivel = scanner.nextInt();
                
                if (consumoCombustivel >= 8 && consumoCombustivel <= 20) {
                    condicao = true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Digite um valor válido para o consumo de combustivel do motor.");
            }
            catch (InputMismatchException e) {
                System.out.println("Valor invalido. Por favor, digite apenas numeros.");
                scanner.nextLine();
            }
        }
        
        return consumoCombustivel;
    }
}
