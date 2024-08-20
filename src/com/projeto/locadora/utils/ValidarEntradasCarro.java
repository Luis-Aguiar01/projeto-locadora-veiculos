package com.projeto.locadora.utils;

import com.projeto.locadora.enums.Cor;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.exceptions.InvalidColorException;
import com.projeto.locadora.exceptions.InvalidModelException;
import com.projeto.locadora.exceptions.InvalidTransmissionException;
import com.projeto.locadora.exceptions.InvalidValueOfQuilometragemException;
import com.projeto.locadora.exceptions.InvalidValueOfValorDiariaException;
import com.projeto.locadora.exceptions.InvalidYearOfCarException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ValidarEntradasCarro {
        private static final Scanner scanner = new Scanner(System.in);
        
        private ValidarEntradasCarro() {}
        
        public static Modelo validarModelo() {
            boolean condicao = false;
            Modelo modelo = null;
            
            while (!condicao) {
                try {
                    exibirOpcoesEnum(Modelo.class);
                    Integer escolha = scanner.nextInt();
                                 
                    if (validarEscolhaEnum(Modelo.class, m -> m.getCodigoModelo() == escolha)) {
                        condicao = true;
                        String nomeEnum = encontrarNomeEnum(Modelo.class, escolha - 1);
                        modelo = Modelo.valueOf(nomeEnum);
                    }
                    else {
                        throw new InvalidModelException();
                    }
                }
                catch (InvalidModelException modelException) {
                    System.out.println("O número escolhido para o modelo está fora do intervalo. Por favor, digite uma opção válida.");
                }
                catch (NumberFormatException formatException) {
                    System.out.println("O formato inserido para o número não é válido. Por favor, digite apenas numeros.");
                    scanner.next();
                }
            }
            
            return modelo;
        }
        
        public static int validarAnoCarro(String mensagem) {
            boolean condicao = false;
            int ano = 0;
            
            while (!condicao) {
                try {
                    System.out.println(mensagem);
                    ano = scanner.nextInt();
                    
                    if (ano > 2014 && ano <= LocalDate.now().getYear()) {
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
                    System.out.println(mensagem);
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
            }
            
            return quilometragem;
        }
        
        public static double validarValorDiariaCarro(String mensagem) {
            boolean condicao = false;
            double valorDiaria = 0.0;
            
            while (!condicao) {
                try {
                    System.out.println(mensagem);
                    valorDiaria = scanner.nextDouble();
                    
                    if (valorDiaria > 0.0) {
                        condicao = true;
                    }
                    else {
                        throw new InvalidValueOfValorDiariaException();
                    }
                }
                catch (InvalidValueOfValorDiariaException valorException) {
                    System.out.println("Por favor, digite um valor para a diária que seja maior que zero.");
                }
            }
            
            return valorDiaria;
        }
        
        public static Cor validarCorCarro() {
            boolean condicao = false;
            Cor corEscolhida = null;
            
            while (!condicao) {      
                try {
                    exibirOpcoesEnum(Cor.class);
                    Integer escolha = scanner.nextInt();
                                 
                    if (validarEscolhaEnum(Cor.class, c -> c.getCodigoCor() == escolha)) {
                        condicao = true;
                        String nomeEnum = encontrarNomeEnum(Cor.class, escolha - 1);
                        corEscolhida = Cor.valueOf(nomeEnum);
                    }
                    else {
                        throw new InvalidColorException();
                    }
                }
                catch (InvalidColorException colorException) {
                    System.out.println("Por favor, digite um valor que esteja no menu.");
                }
            }
            
            return corEscolhida;
        }
        
        public static Transmissao validarTransmissaoCarro() {
            boolean condicao = false;
            Transmissao transmissao = null;
            
            while (!condicao) {
                try {
                    exibirOpcoesEnum(Transmissao.class);
                    Integer escolha = scanner.nextInt();
                                 
                    if (validarEscolhaEnum(Transmissao.class, t -> t.getCodigoTransmissao() == escolha)) {
                        condicao = true;
                        String nomeEnum = encontrarNomeEnum(Transmissao.class, escolha - 1);
                        transmissao = Transmissao.valueOf(nomeEnum);
                    }
                    else {
                        throw new InvalidTransmissionException();
                    }
                }
                catch (InvalidTransmissionException transmissionException) {
                    System.out.println("O número escolhido para a transmissão está fora do intervalo. Por favor, digite uma opção válida.");
                }
                catch (NumberFormatException formatException) {
                    System.out.println("O formato inserido para o número não é válido. Por favor, digite apenas numeros.");
                    scanner.next();
                }
            }
            
            return transmissao;
        }
        
        private static <T extends Enum<T>> void exibirOpcoesEnum(Class<T> enumClass) {
            System.out.println("================================================================");
            System.out.println("||              ESCOLHA UMA OPÇÃO ABAIXO             ||");
            System.out.println("================================================================");

            for (T enumConstant : enumClass.getEnumConstants()) {
                System.out.printf("|| [%d] - %s\n", enumConstant.ordinal() + 1, enumConstant.name());
            }
        }
        
        private static <T extends Enum<T>> boolean validarEscolhaEnum(Class<T> enumClass, Predicate<T> predicate) {
            return Arrays.stream(enumClass.getEnumConstants())
                .filter(predicate)
                .anyMatch(predicate);
        }
        
        private static <T extends Enum<T>> String encontrarNomeEnum(Class<T> enumClass, int escolha) {
            String enumName = "";
            
            for (T e : enumClass.getEnumConstants()) {
                if (e.ordinal() == escolha) {
                    enumName = e.name();
                }
            }
            
            return enumName;
        }
}
