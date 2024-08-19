package com.projeto.locadora.services;

import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.repositories.cliente.ClienteDAO;
import com.projeto.locadora.repositories.cliente.ClienteDAOImp;

import java.util.List;

public class ClienteService {
    private static final ClienteDAO clienteRepositorio = ClienteDAOImp.getInstance();
    private static final ClienteService service = new ClienteService();

    private ClienteService() {}

    public Cliente encontrarClientePorCpf(String cpf) {
        return clienteRepositorio.encontrarClientePorCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cliente com o CPF:\"" + cpf + "\" não encontrado.")
                );
    }

    public void inserirCliente(Cliente cliente) {
        clienteRepositorio.inserirCliente(cliente);
    }

    public List<Cliente> retornarTodosOsClientes() {
        return clienteRepositorio.getAllClientes();
    }

    public void excluirCliente(String cpf) {
        clienteRepositorio.excluirCliente(cpf);
    }

    public void alterarEmailCliente(String cpf, String novoEmail) {
        clienteRepositorio.alterarEmailCliente(cpf, novoEmail);
    }
    
    public void alterarEnderecoCliente(String cpf, String novoEndereco) {
        clienteRepositorio.alterarEnderecoCliente(cpf, novoEndereco);
    }

    public void alterarTelefoneCliente(String cpf, String novoTelefone) {
        clienteRepositorio.alterarTelefoneCliente(cpf, novoTelefone);
    }

    public static ClienteService getInstance() {
        return service;
    }
}
