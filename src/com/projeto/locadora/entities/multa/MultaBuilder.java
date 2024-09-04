package com.projeto.locadora.entities.multa;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface MultaBuilder {
    public MultaBuilder descricao(String descricao);
    public MultaBuilder valor(Double valor);
    public String getDescricao();
    public Double getValor();
    public Multa build();
}