package com.projeto.locadora.entities.pagamento;

import com.projeto.locadora.utils.ValidarEntradas;

public class PagamentoFactory {

    private PagamentoFactory() {}
    
    public static Pagamento criarPagamento() {
        
        double valor = ValidarEntradas.validarEntradaDouble("Insira o valor a ser pago:");
        
        return new PagamentoBuilderImp()
                .valor(valor)
                .build();
        
    }
    
}
