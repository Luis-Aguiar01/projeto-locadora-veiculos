package com.projeto.locadora.entities.pagamento;

import com.projeto.locadora.utils.ValidadorDouble;

/*
    Classe responsável por fornecer  um método para criar um Paganmento personalizado,
    inicializando o mesmo atributo por atributo, com base nas preferências do usuário.
    Essa  classe faz parte da implementação do Padrão Builder.
*/
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
