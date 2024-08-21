package com.projeto.locadora.controllers;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.funcionario.FuncionarioBuilderImp;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.FuncionarioService;
import com.projeto.locadora.utils.FormatarDados;
import com.projeto.locadora.utils.ValidarEntradas;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FuncionarioController {
    
    private static final FuncionarioService service = FuncionarioService.getInstance();
    private static final FuncionarioController controller = new FuncionarioController();

    private FuncionarioController() {}

    public void cadastrarFuncionario() {
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE FUNCIONARIOS                  ||");
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Insira as informações do funcionario abaixo:");

        Funcionario funcionario = new FuncionarioBuilderImp()
                .nome("gabriel pauli")
                .cpf("111.111.111-27")
                .email("g@gmail.com")
                .senha("g123")
                .dataNascimento(LocalDate.now())
                .endereco("Av harmonia")
                .telefone("342")
                .dataRegistro(LocalDateTime.now())
                .build();

        try
        {
            service.inserirFuncionario(funcionario);
        }
        catch(CpfAlreadyRegisteredException e)
        {
            System.out.println("Usuario com CPF já cadastrado.");
        }
        
        System.out.println(service.retornarTodosOsFuncionarios());
    }
    
    public void alterarFuncionario() {
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR DADOS FUNCIONARIO                 ||");
        System.out.println("=============================================================");
        System.out.println();
        
        System.out.println("|| [1] - Alterar Nome do Funcionario.");
        System.out.println("|| [2] - Alterar E-mail do Funcionario.");
        System.out.println("|| [3] - Alterar Senha do Funcionario.");
        System.out.println("|| [4] - Alterar Endereco do Funcionario.");
        System.out.println("|| [5] - Alterar Telefone do Funcionario.");
        System.out.println("|| [6] - Sair.");
        System.out.println();
        
        
        
        try
        {
            
            int opcao;
            
            do{
                opcao = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada:");
                
                switch(opcao)
                {
                    case 1: 
                    {
                        alterarNomeFuncionario();
                        break;
                    }
                    case 2:
                    {
                        alterarEmailFuncionario();
                        break;
                    }
                    case 3:
                    {
                        alterarSenhaFuncionario();
                        break;
                    }
                    case 4:
                    {
                        alterarEnderecoFuncionario();
                        break;
                    }
                    case 5:
                    {
                        alterarTelefoneFuncionario();
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Saindo");
                        break;
                    }
                    default:
                    {
                        System.out.println("Opcao invalida");
                    }
                }
            }while(opcao > 6);
        }
        catch(EntityNotFoundException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
        
        System.out.println(service.retornarTodosOsFuncionarios());
        
    }
    
    public Funcionario solicitaCpfFuncionario() throws EntityNotFoundException
    {
        String cpf = ValidarEntradas.validarEntradaString("Informe o CPF do Funcionario (XXX.XXX.XXX-XX): ", "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        return service.encontrarFuncionarioPorCpf(cpf);
    }
    
    public void alterarNomeFuncionario() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||                ALTERAR NOME FUNCIONARIO                 ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String nome = ValidarEntradas.validarEntradaString("Informe o novo nome do funcionario: ", "([A-Za-zÀ-Ü-à-ü]+)(\\s[A-Za-zÀ-Ü-à-ü]+)+");
        
        nome = FormatarDados.formatarNome(nome);
        
        service.alterarNomeFuncionario(funcionario, nome);
    }
    
    public void alterarEmailFuncionario() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR EMAIL FUNCIONARIO                 ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String email = ValidarEntradas.validarEntradaString("Informe o novo e-mail do funcionario: ", "([a-z0-9\\._])+@([a-z])+(\\.([a-zA-Z])+)+");
        
        service.alterarEmailFuncionario(funcionario, email);
    }
    
    public void alterarSenhaFuncionario() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR SENHA FUNCIONARIO                 ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        // A senha deve começar com uma letra maiuscula, e deve ter de 8 a 16 caracteres, podendo ser letras maiusculas, minusculas, numeros e caracteres especiais
        String senha = ValidarEntradas.validarEntradaString("Informe a nova senha do funcionario: ", "^[A-Z][A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,15}$");
        
        service.alterarSenhaFuncionario(funcionario, senha);
    }
    
    public void alterarEnderecoFuncionario() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR ENDERECO FUNCIONARIO               ||");
        System.out.println("=============================================================");
        System.out.println();   
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String endereco = ValidarEntradas.validarEntradaString("Informe o novo endereco do funcionario: ", "[A-Za-zÀ-Ü-à-ü1-9,.-°]+");
        
        service.alterarEnderecoFuncionario(funcionario, endereco);
    }
    
    public void alterarTelefoneFuncionario() throws EntityNotFoundException
    {
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR TELEFONE FUNCIONARIO               ||");
        System.out.println("=============================================================");
        System.out.println();
        
        Funcionario funcionario = solicitaCpfFuncionario();
        
        String telefone = ValidarEntradas.validarEntradaString("Informe o novo telefone do funcionario((XX)XXXXX-XXXX): ", "\\([1-9]{2}\\)[1-9]{5}-[1-9]{4}");
        
        service.alterarTelefoneFuncionario(funcionario, telefone);
    }


    public static FuncionarioController getInstance() {
        return controller;
    }

    public static void main(String[] args) {
        FuncionarioController controller = FuncionarioController.getInstance();

        controller.cadastrarFuncionario();
        
        controller.alterarFuncionario();
    }
}
