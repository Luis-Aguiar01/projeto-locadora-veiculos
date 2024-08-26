package com.projeto.locadora.enums;

public enum Cor implements PrintarNome {
    BRANCO(1, "Branco"),
    PRETO(2, "Preto"),
    CINZA(3, "Cinza"),
    PRATA(4, "Prata"),
    VERMELHO(5, "Vermelho"),
    AZUL(6, "Azul"),
    VERDE(7, "Verde"),
    AMARELO(8, "Amarelo"),
    MARROM(9, "Marrom"),
    LARANJA(10, "Laranja");
    
    private final int codigoCor;
    private final String nomeCor;
    
    private Cor(int codigoCargo, String nomeCargo) {
        this.nomeCor = nomeCargo;
        this.codigoCor = codigoCargo;
    }

    public int getCodigoCor() {
        return codigoCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }
    
    @Override
    public String getNome() {
        return getNomeCor();
    }
}
