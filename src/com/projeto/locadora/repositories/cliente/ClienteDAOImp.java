package com.projeto.locadora.repositories.cliente;

import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.models.cliente.Cliente;
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
    public void excluirCliente(String cpf) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a exclusão.");
        clientes.remove(cliente);
    }

    @Override
    public void alterarEmailCliente(String cpf, String novoEmail) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a alteração de e-mail.");
        cliente.setEmail(novoEmail);
        atualizarCliente(cpf, cliente);
    }

    @Override
    public void alterarSenhaCliente(String cpf, String novaSenha) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a alteração de senha.");
        cliente.setSenha(novaSenha);
        atualizarCliente(cpf, cliente);
    }

    @Override
    public void alterarEnderecoCliente(String cpf, String novoEndereco) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a alteração de endereço.");
        cliente.setEndereco(novoEndereco);
        atualizarCliente(cpf, cliente);
    }

    @Override
    public void alterarTelefoneCliente(String cpf, String novoTelefone) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a alteração de endereço.");
        cliente.setTelefone(novoTelefone);
        atualizarCliente(cpf, cliente);
    }

    @Override
    public void alterarEstadoCliente(String cpf, boolean novoEstado) {
        Cliente cliente = getCliente(cpf, "Cliente não encontrado para a alteração do estado.");
        cliente.setSuspenso(novoEstado);
        atualizarCliente(cpf, cliente);
    }

    private void atualizarCliente(String cpf, Cliente cliente) {
        int clienteIndice = encontrarIndiceCliente(cpf);
        clientes.set(clienteIndice, cliente);
    }

    private Cliente getCliente(String cpf, String msgException) {
        return encontrarClientePorCpf(cpf)
                .orElseThrow(
                    () -> new EntityNotFoundException(msgException)
                );
    }

    private int encontrarIndiceCliente(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }

        return -1;
    }

    public static ClienteDAOImp getInstance() {
        return repository;
    }
}
