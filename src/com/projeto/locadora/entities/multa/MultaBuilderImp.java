package com.projeto.locadora.entities.multa;

public class MultaBuilderImp implements MultaBuilder {
    private String descricao;
    private Double valor;

    @Override
    public MultaBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public MultaBuilder valor(Double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public Double getValor() {
        return valor;
    }
    
    @Override
    public Multa build() {
        return new Multa(this);
    }
}
