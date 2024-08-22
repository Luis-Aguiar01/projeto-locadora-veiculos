package com.projeto.locadora.enums;

public enum EstadoVeiculo {
    MANUTENCAO_NECESSARIA(1, "Manutencao Necessaria"),
    EM_MANUTENCAO(2, "Em Manutencao"),
    MANUTENCAO_EM_DIA(3, "Manutencao em Dia");
    
    private final int codigoEstadoVeiculo;
    private final String estadoVeiculo;
    
    EstadoVeiculo(int codigoEstadoVeiculo, String estadoVeiculo)
    {
        this.codigoEstadoVeiculo = codigoEstadoVeiculo;
        this.estadoVeiculo = estadoVeiculo;
    }

    public int getCodigoEstadoVeiculo() {
        return codigoEstadoVeiculo;
    }
    
    public String getEstadoVeiculo() {
        return estadoVeiculo;
    }
}
