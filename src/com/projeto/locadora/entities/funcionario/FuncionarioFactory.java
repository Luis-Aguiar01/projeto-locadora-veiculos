package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.utils.*;
import java.time.*;

public class FuncionarioFactory {
    
    private FuncionarioFactory() {}
    private static final ValidadorString validador = ValidadorString.getInstance();
    
    public static Funcionario criarFuncionario() {
        
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
        
        validador.setRegex(ValidacoesRegex.VALIDAR_SENHA_REGEX);
        String senha = validador.validar("Informe a nova senha do funcionario: ");
        
        return new FuncionarioBuilderImp()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .dataNascimento(dataNascimento)
                .endereco(endereco)
                .telefone(telefone)
                .dataRegistro(LocalDateTime.now())
                .senha(senha)
                .build();
    }
}
