package com.projeto.locadora.repositories.cliente;

import com.projeto.locadora.entities.cliente.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/*
    Aplicação do Padrão de Projeto Singleton - O ClienteDAOImp possui apenas 
    uma única instância da sua classe, que é inicializada como um atributo.
    Essa instância é fornecidada pelo método getInstance().
*/
public class ClienteDAOImp implements ClienteDAO {
    
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final ClienteDAOImp repository = new ClienteDAOImp();

    private ClienteDAOImp() {}
    
    
    static 
    {
        Cliente cliente = new ClienteBuilderImp()
                .nome("Cristiano Oliveira")
                .cpf("111.111.111-22")
                .email("c@gmail.com")
                .endereco("Av. vapo")
                .dataNascimento(LocalDate.of(2000,02,02))
                .dataRegistro(LocalDateTime.now())
                .build();

        clientes.add(cliente);
    }
    
    
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
