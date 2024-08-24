package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.*;
import java.time.Year;
import java.util.*;

public class ValidarEntradasCarro {
        private static final Scanner scanner = new Scanner(System.in);
        
        private ValidarEntradasCarro() {}
        
        public static int validarAnoCarro(String mensagem) {
            boolean condicao = false;
            int ano = 0;
            
            while (!condicao) {
                try {
                    System.out.print(mensagem);
                    ano = scanner.nextInt();
                    
                    if (ano > 2014 && ano <= Year.now().getValue()) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidYearOfCarException();
                    }
                }
                catch (InvalidYearOfCarException carException) {
                    System.out.println("Por favor, digite um ano maior que 2014.");
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, digite um numero.");
                    scanner.nextLine();
                }
            }
            
            return ano;
        }
        
        public static double validarQuilometragemCarro(String mensagem) {
            boolean condicao = false;
            double quilometragem = 0.0;
            
            while (!condicao) {
                try {
                    System.out.print(mensagem);
                    quilometragem = scanner.nextDouble();
                    
                    if (quilometragem >= 0.0) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidValueOfQuilometragemException();
                    }
                }
                catch (InvalidValueOfQuilometragemException quilometragemException) {
                    System.out.println("Por favor, digite um valor para a quilometragem que seja maior, ou igual, a zero.");
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, digite um numero.");
                    scanner.nextLine();
                }
            }
            
            return quilometragem;
        }
        
        public static double validarValorDiariaCarro(String mensagem) {
            boolean condicao = false;
            double valorDiaria = 0.0;
            
            while (!condicao) {
                try {
                    System.out.print(mensagem);
                    valorDiaria = scanner.nextDouble();
                    
                    if (valorDiaria >= 100.0) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidValueOfValorDiariaException();
                    }
                }
                catch (InvalidValueOfValorDiariaException valorException) {
                    System.out.println("Por favor, digite um valor para a diária que seja maior, ou igual, a 100.0.");
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, digite um numero.");
                    scanner.nextLine();
                }
            }
            
            return valorDiaria;
        }  
}
