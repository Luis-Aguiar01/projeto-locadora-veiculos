package com.projeto.locadora.controllers.cliente;

import com.projeto.locadora.entities.cliente.*;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.ClienteService;
import com.projeto.locadora.utils.FormatarDados;
import com.projeto.locadora.utils.ValidarEntradas;

public class ClienteController {
    private static final ClienteService service = ClienteService.getInstance();
    private static final ClienteController controller = new ClienteController();

    private ClienteController() {}

    public void cadastrarCliente() {
        
        ClienteInterface.printarInterfaceCadastro();
        Cliente cliente = ClienteFactory.criarCliente();
       
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
        int opcao = 1;
            
        while (opcao != 5)  
        {
            try{
                ClienteInterface.printarMenuEscolhasAlteracao();
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
            catch(EntityNotFoundException e ) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        System.out.println(service.retornarTodosOsClientes());
    }
    
    public Cliente solicitaCpfCliente() throws EntityNotFoundException
    {
        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF do Cliente (XXX.XXX.XXX-XX): ", ClienteFactory.VALIDAR_CPF_CLIENTE_REGEX);
        return service.encontrarClientePorCpf(cpf);
    }
    
    public void alterarNomeCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoNome();
        
        Cliente cliente = solicitaCpfCliente();
        
        String nome = ValidarEntradas.validarEntradaString("Informe o novo nome do cliente: ", ClienteFactory.VALIDAR_NOME_CLIENTE_REGEX);
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeCliente(cliente, nome);
    }
    
    public void alterarEmailCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoEmail();
        
        Cliente cliente = solicitaCpfCliente();
        
        String email = ValidarEntradas.validarEntradaString("Informe o novo e-mail do cliente: ", ClienteFactory.VALIDAR_EMAIL_CLIENTE_REGEX);
        
        service.alterarEmailCliente(cliente, email);
    }
    
    public void alterarEnderecoCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoEndereco();
      
        Cliente cliente = solicitaCpfCliente();
        
        String endereco = ValidarEntradas.validarEntradaString("Informe o novo endereco do cliente: ", ClienteFactory.VALIDAR_ENDERECO_CLIENTE_REGEX);
        
        service.alterarEnderecoCliente(cliente, endereco);
    }
    
    public void alterarTelefoneCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoTelefone();
        
        Cliente cliente = solicitaCpfCliente();
        
        String telefone = ValidarEntradas.validarEntradaString("Informe o novo telefone do cliente((XX)XXXXX-XXXX): ", ClienteFactory.VALIDAR_TELEFONE_CLIENTE_REGEX);
        
        service.alterarTelefoneCliente(cliente, telefone);
    }


    public static ClienteController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        ClienteController controller = ClienteController.getInstance();

        controller.cadastrarCliente();
        
        controller.alterarCliente();
    }
}
