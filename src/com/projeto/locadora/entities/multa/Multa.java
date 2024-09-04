package com.projeto.locadora.entities.multa;

import java.time.LocalDateTime;

/*
    Aplicação do Padrão de Projeto Builder - A Multa recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.
*/
public class Multa {
    private final Integer codigo;
    private final String descricao;
    private Double valor;
    private final LocalDateTime dataHora;
    
    private static int nextCodigo = 1;
    
    public Multa(MultaBuilder builder) {
        this.codigo = nextCodigo;
        nextCodigo++;
        dataHora = LocalDateTime.now();
        
        this.descricao = builder.getDescricao();
        this.valor = builder.getValor();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public static int getNextCodigo() {
        return nextCodigo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        String info = codigo.toString() + "\n";
        info += "Descrição: " + descricao + "\n";
        info += "Valor: " + valor;
        return info;
    }
    
    public static void main(String[] args) {
        Multa multa1 = new MultaBuilderImp()
                .descricao("Não devolveu no prazo")
                .valor(500.99)
                .build();
        
        Multa multa2 = new MultaBuilderImp()
                .descricao("Danificou o carro")
                .valor(500.99)
                .build();
        
        System.out.println(multa1);
        System.out.println(multa2);
    }
}
