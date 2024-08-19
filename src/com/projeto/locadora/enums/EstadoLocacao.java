package com.projeto.locadora.enums;

public enum EstadoLocacao {
    FINALIZADA(1, "Finalizada"),
    EM_ABERTO(2, "Em Aberto"),
    EM_ATRASO(3, "Em Atrado");
    
    private int codigoEstadoLocacao;
    private String estadoLocacao;
    
    EstadoLocacao(int codigoEstadoLocacao, String estadoLocacao)
    {
        this.codigoEstadoLocacao = codigoEstadoLocacao;
        this.estadoLocacao = estadoLocacao;
    }

    public int getCodigoEstadoLocacao() {
        return codigoEstadoLocacao;
    }
    
    public String getEstadoVeiculo() {
        return estadoLocacao;
    }
}
