package com.projeto.locadora.repositories.cliente;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    Optional<Cliente> encontrarClientePorCpf(String cpf);
    void inserirCliente(Cliente usuario);
    List<Cliente> getAllClientes();
    void excluirCliente(String cpf);
    void alterarEmailCliente(String cpf, String novoEmail);
    void alterarSenhaCliente(String cpf, String novaSenha);
    void alterarEnderecoCliente(String cpf, String novoEndereco);
    void alterarTelefoneCliente(String cpf, String novoTelefone);
    void alterarEstadoCliente(String cpf, boolean novoEstado);
}
