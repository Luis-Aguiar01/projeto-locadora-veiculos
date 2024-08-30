package com.projeto.locadora.entities.pagamento;

public interface PagamentoBuilder {
    PagamentoBuilder valor(double valor);
    double getValor();
    Pagamento build();
}
