package com.projeto.locadora.controllers.carro;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.utils.OperacoesConsole;
import java.util.List;

public class CarroInterface {
    
    public static void printarMenuCarro() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||              MENU CARRO                                 ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Cadastrar Carro.                                  ||");
        System.out.println("|| [2] - Alterar Dados do Carro.                           ||");
        System.out.println("|| [3] - Visualizar Informacoes dos Carros.                ||");
        System.out.println("|| [4] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarMenuEscolhasAlteracao() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR DADOS DO CARRO                    ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Alterar Cor do Carro.                             ||");
        System.out.println("|| [2] - Alterar Quilometragem do Carro.                   ||");
        System.out.println("|| [3] - Alterar Valor da Diária do Carro.                 ||");
        System.out.println("|| [4] - Alterar Disponibilidade do Carro.                 ||");
        System.out.println("|| [5] - Alterar Estado do Carro.                          ||");
        System.out.println("|| [6] - Alterar Placa do Carro.                           ||");
        System.out.println("|| [7] - Alterar Motor do Carro.                           ||"); 
        System.out.println("|| [8] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInterfaceCadastro() {
        OperacoesConsole.limparConsole();
        System.out.println("=========================================================");
        System.out.println("||               CADASTRAR NOVO VEÍCULO                ||");
        System.out.println("=========================================================");
    }
    
    public static void printarInterfaceAlteracaoCor() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR COR DO CARRO                      ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoQuilometragem() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||         ALTERAR QUILOMETRAGEM DO CARRO                  ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoValor() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR VALOR DO CARRO                    ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoDisponibilidade() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||         ALTERAR DISPONIBILIDADE DO CARRO                ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoEstado() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR ESTADO DO CARRO                   ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoPlaca() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR PLACA DO CARRO                    ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarInterfaceAlteracaoMotor() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR MOTOR DO CARRO                    ||");
        System.out.println("=============================================================");
        System.out.println();
    }
    
    public static void printarMenuVisualizarInformacoes() {
        System.out.println("=============================================================");
        System.out.println("||           VISUALIZAR INFORMACOES CARRO                  ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Visualizar Carro por Renavam.                     ||");
        System.out.println("|| [2] - Visualizar Carros por Estado.                     ||");
        System.out.println("|| [3] - Visualizar Carros por Disponibilidade.            ||");
        System.out.println("|| [4] - Visualizar Carros por Cor.                        ||");
        System.out.println("|| [5] - Visualizar Carros por Modelo.                     ||");
        System.out.println("|| [6] - Visualizar Carros por Transmissao.                ||");
        System.out.println("|| [7] - Visualizar Carros por Marca.                      ||");
        System.out.println("|| [8] - Sair.                                             ||");
        System.out.println("=============================================================");
    }
    
    public static void printarInformacoesCarros(List<Carro> carros) {
        OperacoesConsole.limparConsole();
        
        for (Carro carro : carros) {
            System.out.println(carro);
            System.out.println("\n------------------------------------------------------------------------------------\n");
        }
    }
}
