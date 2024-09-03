package com.projeto.locadora.controllers.cliente;

import com.projeto.locadora.entities.cliente.*;
import com.projeto.locadora.utils.ValidacoesRegex;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.cliente.ClienteService;
import com.projeto.locadora.utils.FormatarDados;
import static com.projeto.locadora.utils.OperacoesConsole.*;
import com.projeto.locadora.utils.ValidadorInteiro;
import com.projeto.locadora.utils.ValidadorString;
import com.projeto.locadora.utils.ValidarEntradas;

public class ClienteController {
    private static final ClienteService service = ClienteService.getInstance();
    private static final ClienteController controller = new ClienteController();
    private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
    private static final ValidadorString validadorString = ValidadorString.getInstance();
    
    private ClienteController() {}
    
    public void exibirOpcoesCliente()
    {
        int op = 1;
        
        while(op != 4)
        {
            ClienteInterface.printarMenuCliente();
            
            op = validadorInteiro.validar("Informe a Opcao Desejada:");
            
            switch (op) 
            {
                case 1 -> cadastrarCliente();
                case 2 -> alterarCliente();
                case 3 -> visualizarInformacoesClientePorCpf();
                case 4 -> System.out.println("Saindo.");
                default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
            }
        }  
    }

    public void cadastrarCliente() {
        
        ClienteInterface.printarInterfaceCadastro();
        Cliente cliente = ClienteFactory.criarCliente();
       
        try
        {
            service.inserirCliente(cliente);
            
            System.out.println(GREEN + "\nCliente Cadastrado com Sucesso." + RESET);
        }
        catch(CpfAlreadyRegisteredException e)
        {
            System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
        }
    }
    
    public void alterarCliente() {
        int opcao = 1;
            
        while (opcao != 5)  
        {
            try{
                ClienteInterface.printarMenuEscolhasAlteracao();
                opcao = validadorInteiro.validar("Informe a Opcao Desejada:");

                switch(opcao){
                    case 1 -> alterarNomeCliente();
                    case 2 -> alterarEmailCliente();
                    case 3 -> alterarEnderecoCliente();
                    case 4 -> alterarTelefoneCliente();
                    case 5 -> System.out.println("Saindo.");
                    default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
                }
            }
            catch(EntityNotFoundException e ) {
                System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
            }
        }
    }
    
    public Cliente solicitaCpfCliente() throws EntityNotFoundException
    {   
        validadorString.setRegex(ValidacoesRegex.VALIDAR_CPF_REGEX);
        String cpf = validadorString.validar("Informe o CPF do Cliente (XXX.XXX.XXX-XX): ");
        return service.encontrarClientePorCpf(cpf);
    }
    
    public void alterarNomeCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoNome();
        
        Cliente cliente = solicitaCpfCliente();
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_NOME_REGEX);
        String nome = validadorString.validar("Informe o novo nome do cliente: ");
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeCliente(cliente, nome);
    }
    
    public void alterarEmailCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoEmail();
        
        Cliente cliente = solicitaCpfCliente();
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_EMAIL_REGEX);
        String email = validadorString.validar("Informe o novo e-mail do cliente: ");
        
        service.alterarEmailCliente(cliente, email);
    }
    
    public void alterarEnderecoCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoEndereco();
      
        Cliente cliente = solicitaCpfCliente();
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_ENDERECO_REGEX);
        String endereco = validadorString.validar("Informe o novo endereco do cliente: ");
        
        service.alterarEnderecoCliente(cliente, endereco);
    }
    
    public void alterarTelefoneCliente() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceAlteracaoTelefone();
        
        Cliente cliente = solicitaCpfCliente();
        
        validadorString.setRegex( ValidacoesRegex.VALIDAR_TELEFONE_REGEX);
        String telefone = validadorString.validar("Informe o novo telefone do cliente((XX)XXXXX-XXXX): ");
        
        service.alterarTelefoneCliente(cliente, telefone);
    }
    
    public void visualizarInformacoesClientePorCpf() throws EntityNotFoundException
    {
        ClienteInterface.printarInterfaceVisualizarDadosCliente();
        
        Cliente cliente = solicitaCpfCliente();
        
        System.out.println(cliente);
    }


    public static ClienteController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        ClienteController controller = ClienteController.getInstance();

        controller.exibirOpcoesCliente();
    }
}
