package com.projeto.locadora.controllers.funcionario;

import com.projeto.locadora.controllers.carro.CarroController;
import com.projeto.locadora.controllers.cliente.ClienteController;
import com.projeto.locadora.controllers.locacao.LocacaoController;
import com.projeto.locadora.entities.funcionario.*;
import com.projeto.locadora.enums.Cargo;
import com.projeto.locadora.exceptions.*;
import com.projeto.locadora.services.funcionario.FuncionarioService;
import com.projeto.locadora.utils.*;
import static com.projeto.locadora.utils.OperacoesConsole.*;

/*
    Implementação do Padrão de Projeto Facade - A classe FuncionarioController
    é responsável por agrupar todas as funcionalidades do sistema, e fornece
    uma interface simples, para que essas funcionalidades possam ser acessadas,
    diminuindo a complexidade.
*/
public class FuncionarioController {
    
    private static final FuncionarioService service = FuncionarioService.getInstance();
    private static final FuncionarioController funcionarioController = new FuncionarioController();
    private static final ClienteController clienteController = ClienteController.getInstance();
    private static final CarroController carroController = CarroController.getInstance();
    private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
    private static final ValidadorString validadorString = ValidadorString.getInstance();
    private static final LocacaoController locacaoController = LocacaoController.getInstance();

    private FuncionarioController() {}
    
    public void paginaLogin() {
        int op = 1;
        
        while (op != 2) {
            FuncionarioInterface.printarInterfaceLogin();
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> realizarLogin();
                case 2 -> {}
                default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
            }
        }
    }
    
    public void realizarLogin() {
        FuncionarioInterface.printarInterfaceLoginEntrada();
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_CPF_REGEX);
        String cpf = validadorString.validar("Digite o seu CPF: ");
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_SENHA_REGEX);
        String senha = validadorString.validar("Digite a sua senha: ");
        
        try {
            Funcionario funcionario = service.encontrarFuncionarioPorCpf(cpf);
            if (funcionario.getSenha().equals(senha)) {
                if (funcionario.getCargo().equals(Cargo.ADMIN)) {
                    operacoesFuncionarioAdministradorMenu();
                }
                else {
                    operacoesFuncionarioComumMenu();
                }
            }
            else {
                throw new IncorrectPasswordException("A senha fornecida nao confere.");
            }
        }
        catch (EntityNotFoundException | IncorrectPasswordException e) {
            System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
        }
    }
    
    public void operacoesFuncionarioAdministradorMenu() {
        int op = 1;

        while(op != 5) {
            FuncionarioInterface.printarMenuFuncionarioAdministrador();
            
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> clienteController.exibirOpcoesCliente();
                case 2 -> carroController.exibirOpcoesCarro();
                case 3 -> locacaoController.menuLocacao();
                case 4 -> exibirOpcoesAdministrador();
                case 5 -> {}
                default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
            }
        }
    }
    
    public void operacoesFuncionarioComumMenu() {
        int op = 1;
        
        while(op != 4) {
            FuncionarioInterface.printarMenuFuncionarioComum();
            
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> clienteController.exibirOpcoesCliente();
                case 2 -> carroController.exibirOpcoesCarro();
                case 3 -> locacaoController.menuLocacao();
                case 4 -> {}
                default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
            }
        }
    }
    
    public void exibirOpcoesAdministrador() {
        int op = 1;
        
        while(op != 4) {
            FuncionarioInterface.printarMenuFuncionariosGeral();
            
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            
            switch (op) {
                case 1 -> cadastrarFuncionario();
                case 2 -> alterarFuncionarioMenu();
                case 3 -> {} // Consultar dados
                case 4 -> {} // Sair
                default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
            }
        }
    }

    public void cadastrarFuncionario() {
        FuncionarioInterface.printarInterfaceCadastro();
        
        Funcionario funcionario = FuncionarioFactory.criarFuncionario();

        try {
            service.inserirFuncionario(funcionario);
            
            System.out.println(GREEN + "\nFuncionario Cadastrado com Sucesso." + RESET);
        }
        catch(CpfAlreadyRegisteredException e) {
            System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
        }
    }
    
    public void alterarFuncionarioMenu() {
        int opcao = 1;
            
        while(opcao != 6) {
            try {
                FuncionarioInterface.printarMenuAlteracaoDados();
                opcao = validadorInteiro.validar("Informe a Opcao Desejada: ");
                
                switch(opcao)  {
                    case 1 -> alterarNomeFuncionario();
                    case 2 -> alterarEmailFuncionario();           
                    case 3 -> alterarSenhaFuncionario();                   
                    case 4 -> alterarEnderecoFuncionario();                   
                    case 5 -> alterarTelefoneFuncionario();            
                    case 6 -> {}                  
                    default -> System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);   
                }
            }
            catch(EntityNotFoundException e) {
                System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
            }    
        }
    }
    
    public Funcionario solicitaCpfFuncionario() throws EntityNotFoundException {
        validadorString.setRegex("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        String cpf = validadorString.validar("Informe o CPF do Funcionario (XXX.XXX.XXX-XX): ");
        
        return service.encontrarFuncionarioPorCpf(cpf);
    }
    
    public void alterarNomeFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoNome();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        validadorString.setRegex( "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+");
        String nome = validadorString.validar("Informe o novo nome do funcionario: ");
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeFuncionario(funcionario, nome);
    }
    
    public void alterarEmailFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoEmail();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        validadorString.setRegex("([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        String email = validadorString.validar("Informe o novo e-mail do funcionario: ");
        
        service.alterarEmailFuncionario(funcionario, email);
    }
    
    public void alterarSenhaFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoSenha();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        validadorString.setRegex("^[A-Z][A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,15}$");
        String senha = validadorString.validar("Informe a nova senha do funcionario: ");
        
        service.alterarSenhaFuncionario(funcionario, senha);
    }
    
    public void alterarEnderecoFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoEndereco();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        validadorString.setRegex("[A-Za-zÀ-Ü-à-ü1-9,.-°]+");
        String endereco = validadorString.validar("Informe o novo endereco do funcionario: ");
        
        service.alterarEnderecoFuncionario(funcionario, endereco);
    }
    
    public void alterarTelefoneFuncionario() throws EntityNotFoundException {
        FuncionarioInterface.printarInterfaceAlteracaoTelefone();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        validadorString.setRegex("\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");
        String telefone = validadorString.validar("Informe o novo telefone do funcionario((XX)XXXXX-XXXX): ");
        
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
