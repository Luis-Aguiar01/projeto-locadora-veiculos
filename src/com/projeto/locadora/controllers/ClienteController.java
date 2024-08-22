package com.projeto.locadora.controllers;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.cliente.ClienteBuilderImp;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.ClienteService;
import com.projeto.locadora.utils.FormatarDados;
import java.time.LocalDateTime;
import com.projeto.locadora.utils.ValidarEntradas;
import java.time.LocalDate;

public class ClienteController {
    private static final ClienteService service = ClienteService.getInstance();
    private static final ClienteController controller = new ClienteController();

    private ClienteController() {}

    public void cadastrarCliente() {
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE CLIENTES                      ||");
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Insira as informações do cliente abaixo:");

        //String nome = ValidarEntradas.validarEntradaString("Informe o Nome Completo: ", "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+");

        //String cpf = ValidarEntradas.validarEntradaString("Informe o CPF (XXX.XXX.XXX-XX): ", "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

        //String email = ValidarEntradas.validarEntradaString("Informe o E-mail: ", "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        
        //LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (YYYY-MM-DD): ");

        //String endereco = ValidarEntradas.validarEntradaString("Informe o Endereco: ", "[A-Za-zÀ-Ü-à-ü1-9,.-°]+");

        //String telefone = ValidarEntradas.validarEntradaString("Informe o Telefone ((XX)XXXXX-XXXX): ", "\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");

        Cliente cliente = new ClienteBuilderImp()
                .nome("cristiano oliveira")
                .cpf("111.111.111-22")
                .email("c@gmail.com")
                .dataNascimento(LocalDate.now())
                .endereco("Av vapo")
                .telefone("123")
                .dataRegistro(LocalDateTime.now())
                .build();

        try
        {
            service.inserirCliente(cliente);
        }
        catch(CpfAlreadyRegisteredException e)
        {
            System.out.println("Usuario com CPF já cadastrado.");
        }
        
        System.out.println(service.retornarTodosOsClientes());
    }
    
    public void alterarCliente() {
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR DADOS CLIENTE                     ||");
        System.out.println("=============================================================");
        System.out.println();
        
        System.out.println("|| [1] - Alterar Nome do Cliente.");
        System.out.println("|| [2] - Alterar E-mail do Cliente.");
        System.out.println("|| [3] - Alterar Endereco do Cliente.");
        System.out.println("|| [4] - Alterar Telefone do Cliente.");
        System.out.println("|| [5] - Sair.");
        System.out.println();
        
        try {
            int opcao = 1;
            
            while (opcao != 5)  {
                opcao = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada:");
                
                switch(opcao)  {
                    case 1 -> alterarNomeCliente();
                    case 2 -> alterarEmailCliente();
                    case 3 -> alterarEnderecoCliente();
                    case 4 -> alterarTelefoneCliente();
                    case 5 -> System.out.println("Saindo");
                    default -> System.out.println("Opcao invalida");
                }
            }
        }
        catch(EntityNotFoundException e ) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        System.out.println(service.retornarTodosOsClientes());
    }
    
    public Cliente solicitaCpfCliente() throws EntityNotFoundException
    {
        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF do Cliente (XXX.XXX.XXX-XX): ", "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        return service.encontrarClientePorCpf(cpf);
    }
    
    public void alterarNomeCliente() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||                ALTERAR NOME CLIENTE                     ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Cliente cliente = solicitaCpfCliente();
        
        String nome = ValidarEntradas.validarEntradaString("Informe o novo nome do cliente: ", "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+");
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeCliente(cliente, nome);
    }
    
    public void alterarEmailCliente() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR EMAIL CLIENTE                     ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Cliente cliente = solicitaCpfCliente();
        
        String email = ValidarEntradas.validarEntradaString("Informe o novo e-mail do cliente: ", "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        
        service.alterarEmailCliente(cliente, email);
    }
    
    public void alterarEnderecoCliente() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR ENDERECO CLIENTE                   ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Cliente cliente = solicitaCpfCliente();
        
        String endereco = ValidarEntradas.validarEntradaString("Informe o novo endereco do cliente: ", "[A-Za-zÀ-Ü-à-ü1-9,.-°]+");
        
        service.alterarEnderecoCliente(cliente, endereco);
    }
    
    public void alterarTelefoneCliente() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR TELEFONE CLIENTE                   ||");
        System.out.println("=============================================================");
        System.out.println();  
        
        Cliente cliente = solicitaCpfCliente();
        
        String telefone = ValidarEntradas.validarEntradaString("Informe o novo telefone do cliente((XX)XXXXX-XXXX): ", "\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");
        
        service.alterarTelefoneCliente(cliente, telefone);
    }


    public static ClienteController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        ClienteController controller = ClienteController.getInstance();

        controller.cadastrarCliente();
        //controller.cadastrarCliente();
        
        controller.alterarCliente();
    }
}
