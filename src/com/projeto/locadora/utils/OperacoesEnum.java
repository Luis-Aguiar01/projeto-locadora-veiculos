package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.InvalidEnumException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class OperacoesEnum {
        private static final Scanner scanner = SingletonScanner.getInstance();
    
        private OperacoesEnum() {}
    
        public static <T extends Enum<T>> void exibirOpcoesEnum(Class<T> enumClass) {
            System.out.println("================================================================");
            System.out.println("||              ESCOLHA UMA OPÇÃO ABAIXO             ||");
            System.out.println("================================================================");

            for (T enumConstant : enumClass.getEnumConstants()) {
                System.out.printf("|| [%d] - %s\n", enumConstant.ordinal() + 1, enumConstant.name());
            }
            
            System.out.println("================================================================");
        }
        
        public static <T extends Enum<T>> boolean validarEscolhaEnum(Class<T> enumClass, Predicate<T> predicate) {
            return Arrays.stream(enumClass.getEnumConstants())
                .filter(predicate)
                .anyMatch(predicate);
        }
        
        public static <T extends Enum<T>> String encontrarNomeEnum(Class<T> enumClass, int escolha) {
            String enumName = "";
            
            for (T e : enumClass.getEnumConstants()) {
                if (e.ordinal() == escolha) {
                    enumName = e.name();
                }
            }
            
            return enumName;
        }
        
        public static <T extends Enum> T validarEnum(Class<T> classEnum) {
            boolean condicao = false;
            T result = null;
            
            while (!condicao) {
                try {
                    OperacoesEnum.exibirOpcoesEnum(classEnum);
                    Integer escolha = scanner.nextInt();
                                 
                    if (OperacoesEnum.validarEscolhaEnum(classEnum, m -> m.ordinal() + 1 == escolha)) {
                        condicao = true;
                        
                        for (T constant : classEnum.getEnumConstants()) {
                            if (constant.ordinal() + 1 == escolha) {
                                result =  constant;
                            }
                        }
                    }
                    else {
                        throw new InvalidEnumException();
                    }
                }
                catch (InvalidEnumException enumException) {
                    System.out.println("O número escolhido para o modelo está fora do intervalo. Por favor, digite uma opção válida.");
                }
                catch (InputMismatchException e) {
                    System.out.println("O formato inserido para o número não é válido. Por favor, digite apenas numeros.");
                    scanner.next();
                }
            }
            
            return result;
        }
}
