package com.projeto.locadora.controllers.funcionario;

import com.projeto.locadora.utils.OperacoesConsole;

public class FuncionarioInterface {
    
    private FuncionarioInterface() {}
    
    public static void printarMenuFuncionarioAdministrador() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU FUNCIONARIO ADMIN                     ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Funcionario.                            ||");
        System.out.println("|| [2] - Cadastrar Cliente.                                ||");
        System.out.println("|| [3] - Cadastrar Carro.                                  ||");
        System.out.println("|| [4] - Pagina Locacao.                                   ||");
        System.out.println("|| [5] - Alterar Dados do Carro.                           ||");
        System.out.println("|| [6] - Alterar Dados do Funcionario.                     ||");
        System.out.println("|| [7] - Alterar Dados do Cliente.                         ||");
        System.out.println("|| [8] - Visualizar Informacoes dos Carros.                ||");
        System.out.println("|| [9] - Visualizar Informacoes dos Clientes.              ||");
        System.out.println("|| [10] - Visualizar informacoes dos Funcionarios.         ||");
        System.out.println("|| [11] - Sair.                                            ||");
        System.out.println("=============================================================");
    }
    
    public static void printarMenuFuncionarioComum() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU FUNCIONARIO COMUM                     ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Cliente.                                ||");
        System.out.println("|| [2] - Cadastrar Carro.                                  ||");
        System.out.println("|| [3] - Pagina Locacao.                                   ||");
        System.out.println("|| [4] - Alterar Dados do Carro.                           ||");
        System.out.println("|| [5] - Alterar Dados do Cliente.                         ||");
        System.out.println("|| [6] - Visualizar Informacoes dos Carros.                ||");
        System.out.println("|| [7] - Visualizar Informacoes dos Clientes.              ||");
        System.out.println("|| [8] - Sair.                                            ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceCadastro() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE FUNCIONARIOS                  ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informações do funcionario abaixo:");
    }
    
    public static void printarMenuAlteracaoDados() {
        OperacoesConsole.limparConsole();
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
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                ALTERAR NOME FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoEmail() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR EMAIL FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoSenha() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR SENHA FUNCIONARIO                 ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoEndereco() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR ENDERECO FUNCIONARIO               ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceAlteracaoTelefone() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR TELEFONE FUNCIONARIO               ||");
        System.out.println("=============================================================");
    }
    
    public static void main(String[] args) {
        printarMenuFuncionarioAdministrador();
    }
}
