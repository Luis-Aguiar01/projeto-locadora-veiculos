package com.projeto.locadora.utils;

/* 
    Implementação do Padrão de Projeto Template Method - A classe ValidadorDouble
    é uma implementação concreta da classe abstrata.
*/
public class ValidadorDouble extends Validador<Double> {

    private static final ValidadorDouble validador = new ValidadorDouble();
    
    @Override
    protected Double transformarEntrada(String entrada) throws NumberFormatException {
        return Double.valueOf(entrada);
    }

    @Override
    protected boolean validarCondicao(Double valor) {
        return valor > 0.0;
    }

    @Override
    protected String mensagemErro(Exception e) {
        return "O número digitado precisa ser maior do que 0.";
    } 
    
    public static ValidadorDouble getInstance() {
        return validador;
    }
}
