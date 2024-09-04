package com.projeto.locadora.utils;

/* 
    Implementação do Padrão de Projeto Template Method - A classe ValidadorInteiro
    é uma implementação concreta da classe abstrata.
*/
public class ValidadorInteiro extends Validador<Integer> {

    private static final ValidadorInteiro validador = new ValidadorInteiro();
    
    private ValidadorInteiro() {}
    
    @Override
    protected Integer transformarEntrada(String entrada) throws NumberFormatException {
        return Integer.valueOf(entrada);
    }

    @Override
    protected boolean validarCondicao(Integer valor) {
        return valor > 0;
    }

    @Override
    protected String mensagemErro(Exception e) {
        return "O numero digitado precisa ser maior do que 0.";
    }
    
    public static ValidadorInteiro getInstance() {
        return validador;
    }
}
