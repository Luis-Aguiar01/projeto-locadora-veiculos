package com.projeto.locadora.enums;

public enum Combustivel {
    GASOLINA (1, "Gasolina"),
    ETANOL (2, "Etanol"),
    DIESEL (3, "Diesel"),
    GAS_NATURAL (4, "Gas Natural");
    
    private final int codigoCombustivel;
    private final String nomeCombustivel;
    
    Combustivel(int codigoCombustivel, String nomeCombustivel)
    {
        this.codigoCombustivel = codigoCombustivel;
        this.nomeCombustivel = nomeCombustivel;
    }

    public int getCodigoCombustivel() {
        return codigoCombustivel;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }
}
