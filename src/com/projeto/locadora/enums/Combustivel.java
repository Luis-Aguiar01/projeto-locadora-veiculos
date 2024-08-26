package com.projeto.locadora.enums;

public enum Combustivel implements PrintarNome {
    GASOLINA (1, "Gasolina"),
    FLEX (2, "Etanol e Gasolina"),
    DIESEL (3, "Diesel");
    
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

    @Override
    public String getNome() {
         return getNomeCombustivel();
    }
}
