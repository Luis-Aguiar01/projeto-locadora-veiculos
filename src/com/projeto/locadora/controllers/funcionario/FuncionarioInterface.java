package com.projeto.locadora.controllers.funcionario;

import static com.projeto.locadora.utils.OperacoesConsole.*;

public class FuncionarioInterface {
    
    private FuncionarioInterface() {}
    
    public static void printarMenuFuncionariosGeral() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU FUNCIONARIO                           ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Funcionario.                            ||");
        System.out.println("|| [2] - Alterar Dados Funcionario.                        ||");
        System.out.println("|| [3] - Consultar Dados Funcionario.                      ||");
        System.out.println("|| [4] - Sair.                                             ||");
        System.out.println("=============================================================");
    }

    public static void printarMenuFuncionarioAdministrador() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                 MENU FUNCIONARIO ADMIN                  ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Opcoes Clientes                                   ||");
        System.out.println("|| [2] - Opcoes Carros                                     ||");
        System.out.println("|| [3] - Opcoes Locacao                                    ||");
        System.out.println("|| [4] - Opcoes Multa                                      ||");
        System.out.println("|| [5] - Opcoes Admin                                      ||");
        System.out.println("|| [6] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarMenuFuncionarioComum() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU FUNCIONARIO COMUM                     ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Opcoes Clientes                                   ||");
        System.out.println("|| [2] - Opcoes Carros                                     ||");
        System.out.println("|| [3] - Opcoes Locacao                                    ||");
        System.out.println("|| [4] - Opcoes Multa                                      ||");
        System.out.println("|| [5] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceLogin() {
        
        System.out.println("=============================================================");
        System.out.println( "||                    LOGIN FUNCIONARIO                    ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Login                                             ||");
        System.out.println("|| [2] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceLoginEntrada() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              LOGIN FUNCIONARIO                          ||");
        System.out.println("=============================================================");
        System.out.println("Informe os seus dados abaixo para realizar o login:\n");
    }
    
    public static void printarInterfaceCadastro() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE FUNCIONARIOS                  ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informações do funcionario abaixo:");
    }
    
    public static void printarMenuAlteracaoDados() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR DADOS FUNCIONARIO                 ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Alterar Nome do Funcionario.                      ||");
        System.out.println("|| [2] - Alterar E-mail do Funcionario.                    ||");
        System.out.println("|| [3] - Alterar Senha do Funcionario.                     ||");
        System.out.println("|| [4] - Alterar Endereco do Funcionario.                  ||");
        System.out.println("|| [5] - Alterar Telefone do Funcionario.                  ||");
        System.out.println("|| [6] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoNome() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                ALTERAR NOME FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoEmail() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR EMAIL FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoSenha() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR SENHA FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoEndereco() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR ENDERECO FUNCIONARIO               ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoTelefone() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR TELEFONE FUNCIONARIO               ||");
        System.out.println("=============================================================");
    }
    
    public static void main(String[] args) {
        printarInterfaceLogin();
    }
}
