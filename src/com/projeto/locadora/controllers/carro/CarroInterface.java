package com.projeto.locadora.controllers.carro;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.utils.OperacoesConsole;
import java.util.List;

public class CarroInterface {
    
    public static void printarMenuEscolhasAlteracao() {
        OperacoesConsole.limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               ALTERAR DADOS DO CARRO                    ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Alterar Cor do Carro.");
        System.out.println("|| [2] - Alterar Quilometragem do Carro.");
        System.out.println("|| [3] - Alterar Valor da Diária do Carro.");
        System.out.println("|| [4] - Alterar Disponibilidade do Carro.");
        System.out.println("|| [5] - Alterar Estado do Carro.");
        System.out.println("|| [6] - Alterar Placa do Carro.");
        System.out.println("|| [7] - Alterar Motor do Carro.");
        System.out.println("|| [8] - Sair.");
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
        System.out.println("|| [1] - Visualizar Carro por Renavam.");
        System.out.println("|| [2] - Visualizar Carros por Estado.");
        System.out.println("|| [3] - Visualizar Carros por Disponibilidade.");
        System.out.println("|| [4] - Visualizar Carros por Cor.");
        System.out.println("|| [5] - Visualizar Carros por Modelo.");
        System.out.println("|| [6] - Visualizar Carros por Transmissao.");
        System.out.println("|| [7] - Sair.");
        System.out.println("=============================================================");
    }
    
    public static void printarInformacoesCarros(List<Carro> carros) {
        System.out.println("\n------------------------------------------------------------------------------------\n");
        
        for (int i = 0; i < carros.size(); i++) {
            System.out.println("Renavam: " + carros.get(i).getRenavam());
            System.out.println("Placa: " + carros.get(i).getPlaca());
            System.out.println("Modelo: " + carros.get(i).getModelo().getNomeModelo());
            System.out.println("Ano: " + carros.get(i).getAno());
            System.out.println("Cor: " + carros.get(i).getCor().getNomeCor());
            System.out.println("Valor: R$" + carros.get(i).getValor());
            System.out.println("Estado: " + carros.get(i).getEstado().getEstadoVeiculo());
            System.out.println("Disponibilidade: " + carros.get(i).getDisponibilidade().getSituacaoDisponibilidade());
            System.out.println("Transmissao: " + carros.get(i).getTransmissao().getNomeTransmissao());
            
            System.out.println("\n------------------------------------------------------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        printarInterfaceCadastro();
    }
}
