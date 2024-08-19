package com.projeto.locadora.enums;

public enum Disponibilidade {
    DISPONIVEL (1, "Disponivel"),
    INDISPONIVE (2, "Indisponivel");
    
    private int codigoDisponibilidade;
    private String situacaoDisponibilidade;

    private Disponibilidade(int codigoDisponibilidade, String situacaoDisponibilidade) 
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
