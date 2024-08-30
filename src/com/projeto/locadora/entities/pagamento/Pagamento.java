package com.projeto.locadora.entities.pagamento;

import java.time.LocalDateTime;

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
