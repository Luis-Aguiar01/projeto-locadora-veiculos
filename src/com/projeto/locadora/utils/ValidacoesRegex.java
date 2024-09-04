package com.projeto.locadora.utils;

public class ValidacoesRegex 
{
    public static final String VALIDAR_NOME_REGEX = "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+";
    public static final String VALIDAR_CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
    public static final String VALIDAR_EMAIL_REGEX = "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+";
    public static final String VALIDAR_ENDERECO_REGEX = "[ A-Za-zÀ-Ü-à-ü1-9,.-°]+";
    public static final String VALIDAR_TELEFONE_REGEX = "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}";
    public static final String VALIDAR_SENHA_REGEX = "[A-Za-z0-9]{4,15}";
    public static final String VALIDAR_CAMPO_TEXTO_REGEX = "[ÇçÀ-Ü-à-üa-zA-Z0-9\\s-/,.]+";
            
    private ValidacoesRegex(){};
}
