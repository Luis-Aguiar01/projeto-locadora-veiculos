package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.utils.ValidacoesRegex;
import com.projeto.locadora.utils.ValidarEntradas;
import java.time.*;

public class FuncionarioFactory {
    
    private FuncionarioFactory() {}
    
    public static Funcionario criarFuncionario() {
        
        String nome = ValidarEntradas.validarEntradaString("Informe o Nome Completo: ", ValidacoesRegex.VALIDAR_NOME_REGEX);

        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF (XXX.XXX.XXX-XX): ", ValidacoesRegex.VALIDAR_CPF_REGEX);

        String email = ValidarEntradas.validarEntradaString("Informe o E-mail: ", ValidacoesRegex.VALIDAR_EMAIL_REGEX);
        
        LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (DD-MM-YYYY): ");

        String endereco = ValidarEntradas.validarEntradaString("Informe o Endereco: ", ValidacoesRegex.VALIDAR_ENDERECO_REGEX);

        String telefone = ValidarEntradas.validarEntradaString("Informe o Telefone ((XX)XXXXX-XXXX)): ", ValidacoesRegex.VALIDAR_TELEFONE_REGEX);
        
        String senha = ValidarEntradas.validarEntradaString("Informe a nova senha do funcionario: ", ValidacoesRegex.VALIDAR_SENHA_REGEX);
        
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
