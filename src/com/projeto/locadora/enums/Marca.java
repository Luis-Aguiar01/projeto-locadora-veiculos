package com.projeto.locadora.enums;

public enum Marca implements PrintarNome {
    VOLKSWAGEN (1, "Volkswagen"), 
    CHEVROLET (2, "Chevrolet"), 
    FIAT (3, "Fiat"), 
    FORD (4, "Ford"), 
    TOYOTA (5, "Toyota"), 
    HONDA (6, "Honda"), 
    HYUNDAI (7, "Hyundai"), 
    RENAULT (8, "Renault"), 
    JEEP (9, "Jeep"), 
    NISSAN (10, "Nissan");
    
    private final int codigoMarca;
    private final String nomeMarca;
    
    Marca(int codigoMarca, String nomeMarca)
    {
        this.codigoMarca = codigoMarca;
        this.nomeMarca = nomeMarca;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }
    
    @Override
    public String getNome() {
        return getNomeMarca();
    }
}
