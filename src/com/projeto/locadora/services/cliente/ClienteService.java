package com.projeto.locadora.services.cliente;

import com.projeto.locadora.exceptions.*;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.repositories.cliente.*;
import com.projeto.locadora.utils.FormatarDados;
import java.util.List;

/*
    Implementação do Padrão de Projeto Singleton - Todas as classes services possuem
    apenas uma única instância sua, sendo esta armazenada na classe e recebida pelo 
    método getInstance(). O construtor é privado para impedir a criação de objetos da classe.
*/

public class ClienteService {
    private static final ClienteDAO clienteRepositorio = ClienteDAOImp.getInstance();
    private static final ClienteService service = new ClienteService();

    private ClienteService() {}

    public Cliente encontrarClientePorCpf(String cpf) throws EntityNotFoundException{
        return clienteRepositorio.encontrarClientePorCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cliente com o CPF: \"" + cpf + "\" não encontrado.")
                );
    }
    
    public boolean checarCpf(Cliente cliente)
    {
        return clienteRepositorio.getAllClientes()
                .stream()
                .anyMatch(c -> c.getCpf().equals(cliente.getCpf()));
    }

    public void inserirCliente(Cliente cliente) throws CpfAlreadyRegisteredException
    {
        if(!checarCpf(cliente))
        {
            String nome = cliente.getNome();
            
            nome = FormatarDados.formatarNome(nome);
           
            cliente.setNome(nome);
            
            clienteRepositorio.inserirCliente(cliente);
        }
        else
        {
            throw new CpfAlreadyRegisteredException("Usuario com CPF já cadastrado.");
        }
    }

    public List<Cliente> retornarTodosOsClientes() {
        return clienteRepositorio.getAllClientes();
    }
    
    public void alterarNomeCliente(Cliente cliente, String novoNome) {
        clienteRepositorio.alterarNomeCliente(cliente, novoNome);
    }

    public void alterarEmailCliente(Cliente cliente, String novoEmail) {
        clienteRepositorio.alterarEmailCliente(cliente, novoEmail);
    }
    
    public void alterarEnderecoCliente(Cliente cliente, String novoEndereco) {
        clienteRepositorio.alterarEnderecoCliente(cliente, novoEndereco);
    }

    public void alterarTelefoneCliente(Cliente cliente, String novoTelefone) {
        clienteRepositorio.alterarTelefoneCliente(cliente, novoTelefone);
    }

    public static ClienteService getInstance() {
        return service;
    }
}
