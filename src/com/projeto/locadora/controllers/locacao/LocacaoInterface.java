package com.projeto.locadora.controllers.locacao;

import static com.projeto.locadora.utils.OperacoesConsole.limparConsole;

public class LocacaoInterface {
    
    public static void printarMenuLocacao() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU LOCACAO                               ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Locacao.                                ||");
        System.out.println("|| [2] - Aplicar Multas.                                   ||");
        System.out.println("|| [3] - Realizar Devolucao.                               ||");
        System.out.println("|| [4] - Consultar Locacao Por ID.                         ||");
        System.out.println("|| [5] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceCadastro() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE LOCACAO                       ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informacoes da locacao abaixo:\n");
    }
    
    public static void printarInterfaceMulta() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE MULTA                       ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informacoes da multa abaixo:\n");
    }
    
    public static void printarInterfaceDevolucao() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               REALIZAR DEVOLUCAO                        ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informacoes da devolucao abaixo:\n");
    }
    
    public static void printarInterfaceConsultaLocacao() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                DADOS DA LOCACAO                         ||");
        System.out.println("=============================================================");
    }
    
    public static void main(String[] args) {
        printarMenuLocacao();
    }
}
