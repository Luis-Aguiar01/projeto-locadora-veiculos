package com.projeto.locadora.enums;

public enum Cargo {
    ADMIN(1, "Adminstrador"),
    COMUM(2, "Comum");
    
    private final String nomeCargo;
    private final int codigoCargo;
    
    Cargo(int codigoCargo, String nomeCargo) {
        this.codigoCargo = codigoCargo;
        this. nomeCargo = nomeCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }    
}
