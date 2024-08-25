package com.projeto.locadora.entities.funcionario;

import static com.projeto.locadora.entities.cliente.ClienteFactory.*;
import com.projeto.locadora.utils.ValidarEntradas;
import java.time.*;

public class FuncionarioFactory {
    
    private FuncionarioFactory() {}
    
    public static Funcionario criarFuncionario() {
        System.out.println("Insira as informações do cliente abaixo:");
        
        String nome = ValidarEntradas.validarEntradaString("Informe o Nome Completo: ", VALIDAR_NOME_CLIENTE_REGEX);

        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF (XXX.XXX.XXX-XX): ", VALIDAR_CPF_CLIENTE_REGEX);

        String email = ValidarEntradas.validarEntradaString("Informe o E-mail: ", VALIDAR_EMAIL_CLIENTE_REGEX);
        
        LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (DD-MM-YYYY): ");

        String endereco = ValidarEntradas.validarEntradaString("Informe o Endereco: ", VALIDAR_ENDERECO_CLIENTE_REGEX);

        String telefone = ValidarEntradas.validarEntradaString("Informe o Telefone ((XX)XXXXX-XXXX)): ", VALIDAR_TELEFONE_CLIENTE_REGEX);
        
        String senha = ValidarEntradas.validarEntradaString("Informe a nova senha do funcionario: ", "^[A-Z][A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,15}$");
        
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
