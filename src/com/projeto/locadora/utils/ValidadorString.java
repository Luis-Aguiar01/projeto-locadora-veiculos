package com.projeto.locadora.utils;

/* 
    Implementação do Padrão de Projeto Template Method - A classe ValidadorString
    é uma implementação concreta da classe abstrata.
*/
public class ValidadorString extends Validador<String> {
    
    private static final ValidadorString validador = new ValidadorString();
    private String regex;
      
    @Override
    protected String transformarEntrada(String entrada) throws Exception {
        return entrada;
    }

    @Override
    protected boolean validarCondicao(String valor) {
        return valor.matches(regex);
    }

    @Override
    protected String mensagemErro(Exception e) {
        return "O texto digitado esta fora do padrao.";
    }   

    public void setRegex(String regex) {
        this.regex = regex;
    }
    
    public static ValidadorString getInstance() {
        return validador;
    }
}
