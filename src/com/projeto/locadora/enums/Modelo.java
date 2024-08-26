package com.projeto.locadora.enums;

public enum Modelo implements PrintarNome {
    HATCHBACK (1, "Hatchback"),
    SEDAN (2, "Sedan"),
    SUV (3, "SUV"),
    COUPE (4, "Coupe"),
    CONVERSIVEL (5, "Conversivel"),
    PICAPE (6, "Picape"),
    ESPORTIVO (7, "Esportivo");
    
    private final int codigoModelo;
    private final String nomeModelo;
    
    Modelo(int codigoModelo, String nomeModelo)
    {
        this.codigoModelo = codigoModelo;
        this.nomeModelo = nomeModelo;
    }

    public int getCodigoModelo() {
        return codigoModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }
    
    @Override
    public String getNome() {
        return getNomeModelo();
    }
}
