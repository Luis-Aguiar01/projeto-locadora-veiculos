package com.projeto.locadora.repositories.cliente;

import com.projeto.locadora.entities.cliente.Cliente;
import java.util.*;

public interface ClienteDAO {
    Optional<Cliente> encontrarClientePorCpf(String cpf);
    void inserirCliente(Cliente usuario);
    List<Cliente> getAllClientes();
    void alterarNomeCliente(Cliente cliente, String novoNome);
    void alterarEmailCliente(Cliente cliente, String novoEmail);
    void alterarEnderecoCliente(Cliente cliente, String novoEndereco);
    void alterarTelefoneCliente(Cliente cliente, String novoTelefone);
}
