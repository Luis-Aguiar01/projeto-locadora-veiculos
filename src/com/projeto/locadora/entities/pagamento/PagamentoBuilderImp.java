package com.projeto.locadora.entities.pagamento;

public class PagamentoBuilderImp implements PagamentoBuilder {
    
    private double valor;
    
    @Override
    public PagamentoBuilder valor(double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public Pagamento build() {
        return new Pagamento(this);
    }
}
