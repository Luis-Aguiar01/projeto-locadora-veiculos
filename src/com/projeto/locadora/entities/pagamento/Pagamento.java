package com.projeto.locadora.entities.pagamento;

import java.time.LocalDateTime;

/*
    Aplicação do Padrão de Projeto Builder - O Pagamento recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.

    OBS: Assim como as demais entidades, com exceção de Carro e Motor, esta possui 
    um Builder para a criação de instâncias dessa classe. No entanto, o Builder de
    dela apenas fornece um meio de inicializar o objeto personalizado, atributo por atributo,
    sem ter disponível métodos que criam Pagamentos com características especificas.     
*/
public class Pagamento {
    
    private final int codigo;
    private double valor;
    private LocalDateTime dataPagamento;
    
    private static int nextCodigo = 1;

    public Pagamento(PagamentoBuilder builder) {
        this.codigo = nextCodigo;
        nextCodigo++;
        dataPagamento = LocalDateTime.now();
        
        this.valor = builder.getValor();
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codigo=" + codigo + ", valor=" + valor + ", dataPagamento=" + dataPagamento + '}';
    }  
}
