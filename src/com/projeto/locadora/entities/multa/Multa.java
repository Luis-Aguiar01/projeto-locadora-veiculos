package com.projeto.locadora.entities.multa;

import java.time.LocalDateTime;

public class Multa {
    private Integer codigo;
    private String descricao;
    private Double valor;
    private LocalDateTime dataHora;
    
    
    private static int nextCodigo = 1;
    
    public Multa(Builder builder) {
        this.codigo = nextCodigo;
        nextCodigo++;
        dataHora = LocalDateTime.now();
        
        this.descricao = builder.getDescricao();
        this.valor = builder.getValor();
    }
    
    @Override
    public String toString() {
        String info = codigo.toString() + "\n";
        info += "Descrição: " + descricao + "\n";
        info += "Valor: " + valor;
        return info;
    }
    
    public static void main(String[] args) {
        Multa multa1 = new MultaBuilder()
                .descricao("Não devolveu no prazo")
                .valor(500.99)
                .build();
        
        Multa multa2 = new MultaBuilder()
                .descricao("Danificou o carro")
                .valor(500.99)
                .build();
        
        System.out.println(multa1);
        System.out.println(multa2);
    }
}
