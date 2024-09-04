package com.projeto.locadora.entities.pagamento;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface PagamentoBuilder {
    PagamentoBuilder valor(double valor);
    double getValor();
    Pagamento build();
}
