package com.projeto.locadora.utils;

import java.util.Scanner;

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
                System.err.println(mensagemErro(e));
            }
        }
        
        return valor;
    }
    
    protected abstract T transformarEntrada(String entrada) throws Exception;
    protected abstract boolean validarCondicao(T valor);
    protected abstract String mensagemErro(Exception e);
}
