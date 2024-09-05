package com.projeto.locadora.utils;

import static com.projeto.locadora.utils.OperacoesConsole.RED;
import static com.projeto.locadora.utils.OperacoesConsole.RESET;
import java.util.Scanner;

/* 
    Implementação do Padrão de Projeto Template Method - A classe Validador
    serve para definir as operações padrões, que possuem implementaçoes, e as
    operações que precisam de uma implementação por parte das subclasses.
*/

public abstract class Validador<T> {
    private final Scanner scanner = SingletonScanner.getInstance();
    
    public T validar(String mensagem) {
        T valor = null;
        boolean condicao = false;
        
        while (!condicao) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            
            try {
                valor = transformarEntrada(entrada);
                
                if (validarCondicao(valor)) {
                    condicao = true;
                } 
                else {
                    throw new Exception("A condição não foi atendida para o tipo de dado.");
                }
            } 
            catch (Exception e) {
                System.out.println(RED + "\nErro: " + mensagemErro(e) + RESET);
            }
        }
        
        return valor;
    }
    
    protected abstract T transformarEntrada(String entrada) throws Exception;
    protected abstract boolean validarCondicao(T valor);
    protected abstract String mensagemErro(Exception e);
}
