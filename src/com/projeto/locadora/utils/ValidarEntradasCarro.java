package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.*;
import java.time.Year;

public class ValidarEntradasCarro {
        
        private ValidarEntradasCarro() {}
        private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
        
        public static int validarAnoCarro(String mensagem) {
            boolean condicao = false;
            int ano = 0;
            
            while (!condicao) {
                try {
                    ano = validadorInteiro.validar(mensagem);
                    
                    if (ano > 2014 && ano <= Year.now().getValue()) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidYearOfCarException("Valor invalido. Por favor, digite um valor valor valido para o ano do carro.\nIntervalo esperado: Valor maior que 2014 e menor ou igual que " + Year.now().getValue() + ".");
                    }
                }
                catch (InvalidYearOfCarException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            
            return ano;
        }
        
        public static double validarQuilometragemCarro(String mensagem) {
            boolean condicao = false;
            double quilometragem = 0.0;
            
            while (!condicao) {
                try {
                    quilometragem = validadorInteiro.validar(mensagem);
                    
                    if (quilometragem >= 0.0) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidValueOfQuilometragemException("Valor invalido. Por favor, digite um valor valido para a quilometragem do veiculo.\nIntervalo esperado: Valor maior ou igual a zero.");
                    }
                }
                catch (InvalidValueOfQuilometragemException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            
            return quilometragem;
        }
        
        public static double validarValorDiariaCarro(String mensagem) {
            boolean condicao = false;
            double valorDiaria = 0.0;
            
            while (!condicao) {
                try {
                    valorDiaria = validadorInteiro.validar(mensagem);
                    
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
