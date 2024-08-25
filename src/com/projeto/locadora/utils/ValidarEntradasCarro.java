package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.*;
import java.time.Year;

public class ValidarEntradasCarro {
        
        private ValidarEntradasCarro() {}
        
        public static int validarAnoCarro(String mensagem) {
            boolean condicao = false;
            int ano = 0;
            
            while (!condicao) {
                try {
                    ano = ValidarEntradas.validarEntradaInteira(mensagem);
                    
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
            }
            
            return ano;
        }
        
        public static double validarQuilometragemCarro(String mensagem) {
            boolean condicao = false;
            double quilometragem = 0.0;
            
            while (!condicao) {
                try {
                    quilometragem = ValidarEntradas.validarEntradaInteira(mensagem);
                    
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
            }
            
            return quilometragem;
        }
        
        public static double validarValorDiariaCarro(String mensagem) {
            boolean condicao = false;
            double valorDiaria = 0.0;
            
            while (!condicao) {
                try {
                    valorDiaria = ValidarEntradas.validarEntradaDouble(mensagem);
                    
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
            }
            
            return valorDiaria;
        }  
}
