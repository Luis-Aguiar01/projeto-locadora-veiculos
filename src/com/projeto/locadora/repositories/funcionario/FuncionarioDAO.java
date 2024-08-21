package com.projeto.locadora.repositories.funcionario;

import com.projeto.locadora.entities.funcionario.Funcionario;
import java.util.List;
import java.util.Optional;

public interface FuncionarioDAO {
    Optional<Funcionario> encontrarFuncionarioPorCpf(String cpf);
    void inserirFuncionario(Funcionario usuario);
    List<Funcionario> getAllFuncionarios();
    void alterarNomeFuncionario(Funcionario funcionario, String novoNome);
    void alterarEmailFuncionario(Funcionario funcionario, String novoEmail);
    void alterarSenha(Funcionario funcionario, String novaSenha);
    void alterarEnderecoFuncionario(Funcionario funcionario, String novoEndereco);
    void alterarTelefoneFuncionario(Funcionario funcionario, String novoTelefone);
}
