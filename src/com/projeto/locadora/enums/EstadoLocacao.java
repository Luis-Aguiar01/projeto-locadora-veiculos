package com.projeto.locadora.enums;

public enum EstadoLocacao implements PrintarNome {
    FINALIZADA(1, "Finalizada"),
    EM_ABERTO(2, "Em Aberto"),
    EM_ATRASO(3, "Em Atrado");
    
    private final int codigoEstadoLocacao;
    private final String estadoLocacao;
    
    EstadoLocacao(int codigoEstadoLocacao, String estadoLocacao)
    {
        this.codigoEstadoLocacao = codigoEstadoLocacao;
        this.estadoLocacao = estadoLocacao;
    }

    public int getCodigoEstadoLocacao() {
        return codigoEstadoLocacao;
    }
    
    public String getEstadoLocacao() {
        return estadoLocacao;
    }
    
    @Override
    public String getNome() {
        return getEstadoLocacao();
    }
}
