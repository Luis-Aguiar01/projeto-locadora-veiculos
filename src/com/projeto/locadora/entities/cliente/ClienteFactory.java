package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.utils.ValidarEntradas;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteFactory {
    
    public static final String VALIDAR_NOME_CLIENTE_REGEX = "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+";
    public static final String VALIDAR_CPF_CLIENTE_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
    public static final String VALIDAR_EMAIL_CLIENTE_REGEX = "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+";
    public static final String VALIDAR_ENDERECO_CLIENTE_REGEX = "[ A-Za-zÀ-Ü-à-ü1-9,.-°]+";
    public static final String VALIDAR_TELEFONE_CLIENTE_REGEX = "\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}";
    
    public static Cliente criarCliente()
    {
        
        System.out.println("Insira as informações do cliente abaixo:");
        
        String nome = ValidarEntradas.validarEntradaString("Informe o Nome Completo: ", VALIDAR_NOME_CLIENTE_REGEX);

        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF (XXX.XXX.XXX-XX): ", VALIDAR_CPF_CLIENTE_REGEX);

        String email = ValidarEntradas.validarEntradaString("Informe o E-mail: ", VALIDAR_EMAIL_CLIENTE_REGEX);
        
        LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (YYYY-MM-DD): ");

        String endereco = ValidarEntradas.validarEntradaString("Informe o Endereco: ", VALIDAR_ENDERECO_CLIENTE_REGEX);

        String telefone = ValidarEntradas.validarEntradaString("Informe o Telefone ((XX)XXXXX-XXXX)): ", VALIDAR_TELEFONE_CLIENTE_REGEX);
        
        return new ClienteBuilderImp()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .dataNascimento(dataNascimento)
                .endereco(endereco)
                .telefone(telefone)
                .dataRegistro(LocalDateTime.now())
                .build();
        
    }
    
}
