package com.projeto.locadora.entities.pagamento;

import com.projeto.locadora.utils.ValidadorDouble;

public class PagamentoFactory {

    private PagamentoFactory() {}
    private static final ValidadorDouble validadorDouble = ValidadorDouble.getInstance();
    
    public static Pagamento criarPagamento() {
        
        double valor = validadorDouble.validar("Insira o valor a ser pago:");
        
        return new PagamentoBuilderImp()
                .valor(valor)
                .build();
    }
}
