package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.InvalidEnumException;
import java.util.Arrays;
import java.util.function.Predicate;
import com.projeto.locadora.enums.PrintarNome;
import static com.projeto.locadora.utils.OperacoesConsole.*;

public class OperacoesEnum {
    
        private OperacoesEnum() {}
    
        public static <T extends Enum<T> & PrintarNome> void exibirOpcoesEnum(Class<T> enumClass) {
            limparConsole();
            System.out.println("================================================================");
            System.out.println("||                   MENU DE OPCOES                           ||");
            System.out.println("================================================================");

            for (T enumConstant : enumClass.getEnumConstants()) {
                System.out.printf("|| [%d] - %s\n", enumConstant.ordinal() + 1, enumConstant.getNome());
            }
            
            System.out.println("================================================================");
        }
        
        public static <T extends Enum<T> & PrintarNome> boolean validarEscolhaEnum(Class<T> enumClass, Predicate<T> predicate) {
            return Arrays.stream(enumClass.getEnumConstants())
                .anyMatch(predicate);
        }
        
        public static <T extends Enum<T> & PrintarNome> T validarEnum(Class<T> classEnum) {
            boolean condicao = false;
            T result = null;
            
            while (!condicao) {
                try {
                    OperacoesEnum.exibirOpcoesEnum(classEnum);
                    int escolha = ValidarEntradas.validarEntradaInteira("Informe a opcao desejada: ");
                                 
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
            }
            
            return result;
        }
}
