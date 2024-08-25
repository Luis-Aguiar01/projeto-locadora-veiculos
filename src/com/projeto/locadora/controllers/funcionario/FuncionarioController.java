package com.projeto.locadora.controllers.funcionario;

import com.projeto.locadora.controllers.carro.CarroController;
import com.projeto.locadora.controllers.cliente.ClienteController;
import com.projeto.locadora.entities.funcionario.*;
import com.projeto.locadora.exceptions.*;
import com.projeto.locadora.services.FuncionarioService;
import com.projeto.locadora.utils.*;

public class FuncionarioController {
    
    private static final FuncionarioService service = FuncionarioService.getInstance();
    private static final FuncionarioController funcionarioController = new FuncionarioController();
    private static final ClienteController clienteController = ClienteController.getInstance();
    private static final CarroController carroController = CarroController.getInstance();

    private FuncionarioController() {}
    
    public void operacoesFuncionarioAdministradorMenu() {
        int op = 1;

        while(op != 11) {
            FuncionarioInterface.printarMenuFuncionarioAdministrador();
            
            op = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> cadastrarFuncionario();
                case 2 -> clienteController.cadastrarCliente();
                case 3 -> carroController.cadastrarNovoCarro();
                case 4 -> {}
                case 5 -> carroController.alterarDadosCarroMenu();
                case 6 -> alterarFuncionarioMenu();
                case 7 -> {}
                case 8 -> carroController.visualizarInformacoesCarroMenu();
                case 9 -> {}
                case 10 -> {}
                case 11 -> {}
                default -> System.out.println("Operacao invalida. Digite uma opcao do menu.");
            }
        }
    }
    
    public void operacoesFuncionarioComumMenu() {
        int op = 1;
        
        while(op != 8) {
            FuncionarioInterface.printarMenuFuncionarioComum();
            
            op = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> clienteController.cadastrarCliente();
                case 2 -> carroController.cadastrarNovoCarro();
                case 3 -> {}
                case 4 -> carroController.alterarDadosCarroMenu();
                case 5 -> {}
                case 6 -> carroController.visualizarInformacoesCarroMenu();
                case 7 -> {}
                case 8 -> {}
                default -> System.out.println("Operacao invalida. Digite uma opcao do menu.");
            }
        }
    }

    public void cadastrarFuncionario() {
        FuncionarioInterface.printarInterfaceCadastro();
        
        Funcionario funcionario = FuncionarioFactory.criarFuncionario();

        try {
            service.inserirFuncionario(funcionario);
        }
        catch(CpfAlreadyRegisteredException e) {
            System.out.println("Usuario com CPF já cadastrado.");
        }
    }
    
    public void alterarFuncionarioMenu() {
        int opcao = 1;
            
        while(opcao != 6) {
            try {
                FuncionarioInterface.printarMenuAlteracaoDados();
                opcao = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada: ");
                
                switch(opcao)  {
                    case 1 -> alterarNomeFuncionario();
                    case 2 -> alterarEmailFuncionario();           
                    case 3 -> alterarSenhaFuncionario();                   
                    case 4 -> alterarEnderecoFuncionario();                   
                    case 5 -> alterarTelefoneFuncionario();            
                    case 6 -> {}                  
                    default -> System.out.println("Opcao invalida");   
                }
            }
            catch(EntityNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            }    
        }
    }
    
    public Funcionario solicitaCpfFuncionario() throws EntityNotFoundException {
        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF do Funcionario (XXX.XXX.XXX-XX): ", "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        return service.encontrarFuncionarioPorCpf(cpf);
    }
    
    public void alterarNomeFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoNome();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String nome = ValidarEntradas.validarEntradaString("Informe o novo nome do funcionario: ", "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+");
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeFuncionario(funcionario, nome);
    }
    
    public void alterarEmailFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoEmail();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String email = ValidarEntradas.validarEntradaString("Informe o novo e-mail do funcionario: ", "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        
        service.alterarEmailFuncionario(funcionario, email);
    }
    
    public void alterarSenhaFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoSenha();
        
        Funcionario funcionario = solicitaCpfFuncionario();
      
        String senha = ValidarEntradas.validarEntradaString("Informe a nova senha do funcionario: ", "^[A-Z][A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,15}$");
        
        service.alterarSenhaFuncionario(funcionario, senha);
    }
    
    public void alterarEnderecoFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoEndereco();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String endereco = ValidarEntradas.validarEntradaString("Informe o novo endereco do funcionario: ", "[A-Za-zÀ-Ü-à-ü1-9,.-°]+");
        
        service.alterarEnderecoFuncionario(funcionario, endereco);
    }
    
    public void alterarTelefoneFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoTelefone();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String telefone = ValidarEntradas.validarEntradaString("Informe o novo telefone do funcionario((XX)XXXXX-XXXX): ", "\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");
        
        service.alterarTelefoneFuncionario(funcionario, telefone);
    }

    public static FuncionarioController getInstance() {
        return funcionarioController;
    }

    public static void main(String[] args) {
        FuncionarioController controller = FuncionarioController.getInstance();
        controller.alterarFuncionarioMenu();
    }
}
