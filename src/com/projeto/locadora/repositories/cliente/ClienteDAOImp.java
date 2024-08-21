package com.projeto.locadora.repositories.cliente;

import com.projeto.locadora.entities.cliente.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClienteDAOImp implements ClienteDAO {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final ClienteDAOImp repository = new ClienteDAOImp();

    private ClienteDAOImp() {}

    @Override
    public Optional<Cliente> encontrarClientePorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    @Override
    public void inserirCliente(Cliente usuario) {
        clientes.add(usuario);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return Collections.unmodifiableList(clientes);
    }
    
    @Override
    public void alterarNomeCliente(Cliente cliente, String novoNome) {
        cliente.setNome(novoNome); 
    }

    @Override
    public void alterarEmailCliente(Cliente cliente, String novoEmail) {
        cliente.setEmail(novoEmail); 
    }

    @Override
    public void alterarEnderecoCliente(Cliente cliente, String novoEndereco) {
        cliente.setEndereco(novoEndereco);
    }

    @Override
    public void alterarTelefoneCliente(Cliente cliente, String novoTelefone) { 
        cliente.setTelefone(novoTelefone);
    }
    
    public static ClienteDAOImp getInstance() {
        return repository;
    }
}
