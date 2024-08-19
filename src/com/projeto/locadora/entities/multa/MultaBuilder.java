package com.projeto.locadora.entities.multa;

public interface MultaBuilder {
    public MultaBuilder descricao(String descricao);
    public MultaBuilder valor(Double valor);
    public String getDescricao();
    public Double getValor();
    public Multa build();
}