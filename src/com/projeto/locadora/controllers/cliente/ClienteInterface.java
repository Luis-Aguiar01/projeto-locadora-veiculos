package com.projeto.locadora.controllers.cliente;

import com.projeto.locadora.utils.OperacoesConsole;

public class ClienteInterface {
    
    public static void printarMenuCliente() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                   MENU DE CLIENTE                       ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Cliente.");
        System.out.println("|| [2] - Alterar Dados Cliente.");
        System.out.println("|| [3] - Exibir Dados Cliente.");
        System.out.println("|| [4] - Sair.");
        System.out.println("=============================================================");
    }
    
    public static void printarMenuEscolhasAlteracao() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              ALTERAR DADOS DO CLIENTE                   ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Alterar Nome do Cliente.");
        System.out.println("|| [2] - Alterar E-mail do Cliente.");
        System.out.println("|| [3] - Alterar Endereco do Cliente.");
        System.out.println("|| [4] - Alterar Telefone do Cliente.");
        System.out.println("|| [5] - Sair.");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceCadastro() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||               CADASTRAR NOVO CLIENTE                ||");
        System.out.println("=========================================================");
    }
    
    public static void printarInterfaceAlteracaoNome() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                ALTERAR NOME CLIENTE                     ||");
        System.out.println("=============================================================");
        System.out.println();  
    }
    
    public static void printarInterfaceAlteracaoEmail() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||                ALTERAR EMAIL CLIENTE                ||");
        System.out.println("=========================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoEndereco() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||               ALTERAR ENDERECO CLIENTE              ||");
        System.out.println("=========================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoTelefone() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||              ALTERAR TELEFONE CLIENTE               ||");
        System.out.println("=========================================================");
        System.out.println();
    }
    
    public static void printarInterfaceVisualizarDadosCliente() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||              VISUALIZAR DADOS CLIENTE               ||");
        System.out.println("=========================================================");
        System.out.println();
    }
    
}
