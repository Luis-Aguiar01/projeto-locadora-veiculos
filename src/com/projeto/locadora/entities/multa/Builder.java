package com.projeto.locadora.entities.multa;

public interface Builder {
    public Builder descricao(String descricao);
    public Builder valor(Double valor);
    public String getDescricao();
    public Double getValor();
    public Multa build();
}