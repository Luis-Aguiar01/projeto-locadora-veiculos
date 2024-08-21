package com.projeto.locadora.utils;

public class FormatarDados {
    
    public static String formatarNome(String nome)
    {
        String novoNome = "";
        String[] nomes = nome.split(" ");
            
        for(String n : nomes)
        {
            novoNome += n.substring(0,1).toUpperCase();
            novoNome += n.substring(1);
            novoNome += " ";
        }
        
        return novoNome.trim();
    }
}
