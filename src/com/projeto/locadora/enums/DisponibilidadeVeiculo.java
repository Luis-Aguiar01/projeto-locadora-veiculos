package com.projeto.locadora.enums;

public enum DisponibilidadeVeiculo {
    DISPONIVEL (1, "Disponivel"),
    INDISPONIVEL (2, "Indisponivel");
    
    private final int codigoDisponibilidade;
    private final String situacaoDisponibilidade;

    private DisponibilidadeVeiculo(int codigoDisponibilidade, String situacaoDisponibilidade) 
    {
        this.codigoDisponibilidade = codigoDisponibilidade;
        this.situacaoDisponibilidade = situacaoDisponibilidade;
    }

    public int getCodigoDisponibilidade() {
        return codigoDisponibilidade;
    }

    public String getSituacaoDisponibilidade() {
        return situacaoDisponibilidade;
    }
}
