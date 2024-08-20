package com.projeto.locadora.controllers;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.cliente.ClienteBuilderImp;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.services.ClienteService;
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

        //String cpf = ValidarEntradas.validarEntradaString("Informe o CPF (XXX.XXX.XXX-XX): ", "\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}");

        //String email = ValidarEntradas.validarEntradaString("Informe o E-mail: ", "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        
        //LocalDate dataNascimento = ValidarEntradas.validarEntradaData("Informe a Data de Nascimento (YYYY-MM-DD): ");

        //String endereco = ValidarEntradas.validarEntradaString("Informe o Endereco: ", "[A-Za-zÀ-Ü-à-ü1-9,.-°]+");

        //String telefone = ValidarEntradas.validarEntradaString("Informe o Telefone (+55(XX)XXXXX-XXXX): ", "\\+55\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");

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


    public static ClienteController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        ClienteController controller = ClienteController.getInstance();

        controller.cadastrarCliente();
        //controller.cadastrarCliente();
    }
}
