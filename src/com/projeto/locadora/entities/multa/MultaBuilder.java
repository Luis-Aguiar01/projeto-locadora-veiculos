package com.projeto.locadora.entities.multa;

public class MultaBuilder implements Builder {
    private String descricao;
    private Double valor;

    @Override
    public Builder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public Builder valor(Double valor) {
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
