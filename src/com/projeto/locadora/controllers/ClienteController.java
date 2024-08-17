package com.projeto.locadora.controllers;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.cliente.ClienteBuilder;
import com.projeto.locadora.services.ClienteService;
import java.time.LocalDate;
import java.util.Scanner;

public class ClienteController {
    private static final ClienteService service = ClienteService.getInstance();
    private static final ClienteController controller = new ClienteController();
    private static final Scanner input = new Scanner(System.in);

    private ClienteController() {}

    public void cadastrarCliente() {
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE CLIENTES                      ||");
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Insira as informações do cliente abaixo:");

        System.out.println("Nome Completo: ");
        String nome = input.nextLine();

        System.out.println("CPF: ");
        String cpf = input.nextLine();

        System.out.println("E-mail: ");
        String email = input.nextLine();

        System.out.println("Senha: ");
        String senha = input.nextLine();

        System.out.println("Data de nascimento(YYYY-MM-DD): ");
        String dataNascimento = input.nextLine();

        System.out.println("Endereço: ");
        String endereco = input.nextLine();

        System.out.println("Telefone: ");
        String telefone = input.nextLine();

        Cliente cliente = new ClienteBuilder()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .senha(senha)
                .dataNascimento(LocalDate.parse(dataNascimento))
                .endereco(endereco)
                .telefone(telefone)
                .dataRegistro(LocalDate.now())
                .suspenso(false)
                .build();

        service.inserirCliente(cliente);
        System.out.println(service.retornarTodosOsClientes());
    }


    public static ClienteController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        ClienteController controller = ClienteController.getInstance();

        controller.cadastrarCliente();
    }
}
