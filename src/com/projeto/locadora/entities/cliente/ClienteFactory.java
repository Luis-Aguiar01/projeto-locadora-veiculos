package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.utils.*;
import java.time.*;


public class ClienteFactory {
    
    private static final ValidadorString validador = ValidadorString.getInstance();
    
    public static Cliente criarCliente() {
        
        validador.setRegex(ValidacoesRegex.VALIDAR_NOME_REGEX);
        String nome = validador.validar("Informe o Nome Completo: ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_CPF_REGEX);
        String cpf = validador.validar("Informe o CPF (XXX.XXX.XXX-XX): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_EMAIL_REGEX);
        String email = validador.validar("Informe o E-mail: ");
        
        LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (DD-MM-YYYY): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_ENDERECO_REGEX);
        String endereco = validador.validar("Informe o Endereco: ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_TELEFONE_REGEX);
        String telefone = validador.validar("Informe o Telefone ((XX)XXXXX-XXXX)): ");
        
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
