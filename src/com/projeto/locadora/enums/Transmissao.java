package com.projeto.locadora.enums;

public enum Transmissao {
    MANUAL (1, "Manual"),
    AUTOMATICO (2, "Automatico"),
    SEMI_AUTOMATICO (3, "Semi-Automatico");
    
    private final int codigoTransmissao;
    private final String nomeTransmissao;

    private Transmissao(int codigoTransmissao, String nomeTransmissao) {
        this.codigoTransmissao = codigoTransmissao;
        this.nomeTransmissao = nomeTransmissao;
    }

    public int getCodigoTransmissao() {
        return codigoTransmissao;
    }

    public String getNomeTransmissao() {
        return nomeTransmissao;
    }
}
