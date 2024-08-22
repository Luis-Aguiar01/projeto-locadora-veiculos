package com.projeto.locadora.controllers.carro;

import com.projeto.locadora.entities.carro.*;
import com.projeto.locadora.entities.motor.*;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.CarroService;
import com.projeto.locadora.utils.*;
import java.util.List;

public class CarroController {
    private final static CarroService service = CarroService.getInstance();
    private final static CarroController controller = new CarroController();
    
    private CarroController() {}
    
    private void cadastrarNovoCarro() {
        CarroInterface.printarInterfaceCadastro();
        Carro carro = CarroFactory.criarCarro();
        
        service.cadastrarCarro(carro);
    }
    
    private void alterarDadosCarroMenu() {
        int opcao = 1;
            
         while (opcao != 8)  { 
            try {
                CarroInterface.printarMenuEscolhasAlteracao();
                opcao = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada: ");

                switch(opcao)  {
                    case 1 -> alterarCorCarro();
                    case 2 -> alterarQuilometragemCarro();
                    case 3 -> alterarValorCarro();
                    case 4 -> alterarDisponibilidadeCarro();
                    case 5 -> alterarEstadoCarro();
                    case 6 -> alterarPlacaCarro();
                    case 7 -> alterarMotorCarro();
                    case 8 -> System.out.println("Saindo");
                    default -> System.out.println("Opcao invalida");
                }
                
                 System.out.println(service.retornarTodosOsCarros());
            }
            catch(EntityNotFoundException e ) {
                System.out.println("Erro: " + e.getMessage());
            }   
        }
    }
    
    private void alterarCorCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoCor();
        
        Carro carro = encontrarCarroPorRenavam();
        Cor novaCor = ValidarEntradasCarro.validarCorCarro();
        
        service.alterarCorCarro(carro, novaCor);
    }
    
    private void alterarQuilometragemCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoQuilometragem();
        
        Carro carro = encontrarCarroPorRenavam();
        double novaQuilometragem = 
                carro.getQuilometragem() + ValidarEntradas.validarEntradaDouble("Digite quantos quilometros foram rodados: ");
        
        service.alterarQuilometragemCarro(carro, novaQuilometragem);
    }
    
    private void alterarValorCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoValor();
        
        Carro carro = encontrarCarroPorRenavam();
        double novoValor = ValidarEntradas.validarEntradaDouble("Digite o novo valor da diaria do carro: ");
        
        service.alterarValorCarro(carro, novoValor);
    }
    
    private void alterarDisponibilidadeCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoDisponibilidade();
        
        Carro carro = encontrarCarroPorRenavam();
        DisponibilidadeVeiculo novaDisponibilidade = ValidarEntradasCarro.validarDisponibilidadeCarro();
        
        service.alterarDisponibilidadeCarro(carro, novaDisponibilidade);
    }
    
    private void alterarEstadoCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoEstado();
        
        Carro carro = encontrarCarroPorRenavam();
        EstadoVeiculo novoEstado = ValidarEntradasCarro.validarEstadoCarro();
        
        service.alterarEstadoCarro(carro, novoEstado); 
    }
    
    private void alterarPlacaCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoPlaca();
        
        Carro carro = encontrarCarroPorRenavam();
        String novaPlaca = 
                ValidarEntradas.validarEntradaString(
                        "Digite a nova placa do carro (AAA-0000 ou AAA0A00):  ",
                        CarroFactory.VALIDAR_PLACA_CARRO_REGEX
                );
         
        service.alterarPlacaCarro(carro, novaPlaca);
    }
    
    private void alterarMotorCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoMotor();
        
        Carro carro = encontrarCarroPorRenavam();
        Motor novoMotor = MotorFactory.criarMotor();
        
        service.alterarMotorCarro(carro, novoMotor);
    }
    
    private void visualizarInformacoesCarroMenu() {
        int opcao = 1;
       
        while (opcao != 7)  { 
            try {
                CarroInterface.printarMenuVisualizarInformacoes();
                opcao = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada: ");
                
                switch(opcao)  {
                    case 1 -> visualizarCarroPorRenavam();
                    case 2 -> visualizarCarrosPorEstado();
                    case 3 -> visualizarCarrosPorDisponibilidade();
                    case 4 -> visualizarCarrosPorCor();
                    case 5 -> visualizarCarrosPorModelo();
                    case 6 -> visualizarCarrosPorTransmissao();
                    case 7 -> System.out.println("Saindo...");
                    default -> System.out.println("Opcao invalida");
                }
            }
            catch(EntityNotFoundException e ) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    private void visualizarCarroPorRenavam() {
        Carro carro = encontrarCarroPorRenavam();
        CarroInterface.printarInformacoesCarros(List.of(carro));
    }
    
    private void visualizarCarrosPorEstado() {
        EstadoVeiculo estado = ValidarEntradasCarro.validarEstadoCarro();
        List<Carro> carrosPorEstado = service.retornarTodosOsCarrosPorEstado(estado);
        CarroInterface.printarInformacoesCarros(carrosPorEstado);
    }
    
    private void visualizarCarrosPorDisponibilidade() {
        DisponibilidadeVeiculo disponibilidade = ValidarEntradasCarro.validarDisponibilidadeCarro();
        List<Carro> carrosPorDispobilidade = service.retornarTodosOsCarrosPorDisponibilidade(disponibilidade);
        CarroInterface.printarInformacoesCarros(carrosPorDispobilidade);
    }
    
    private void visualizarCarrosPorCor() {
        Cor cor = ValidarEntradasCarro.validarCorCarro();
        List<Carro> carrosPorCor = service.retornarTodosOsCarrosPorCor(cor);
        CarroInterface.printarInformacoesCarros(carrosPorCor);
    }
    
    private void visualizarCarrosPorModelo() {
        Modelo modelo = ValidarEntradasCarro.validarModelo();
        List<Carro> carrosPorModelo = service.retornarTodosOsCarrosPorModelo(modelo);
       CarroInterface.printarInformacoesCarros(carrosPorModelo);
    }
    
    private void visualizarCarrosPorTransmissao() {
        Transmissao transmissao = ValidarEntradasCarro.validarTransmissaoCarro();
        List<Carro> carrosPorTransmisao = service.retornarTodosOsCarrosPorTransmissao(transmissao);
        CarroInterface.printarInformacoesCarros(carrosPorTransmisao);
    }

    private Carro encontrarCarroPorRenavam() {
        String renavam = 
                ValidarEntradas.validarEntradaString("Informe o renavam do carro:", CarroFactory.VALIDAR_RENAVAM_CARRO_REGEX);
        return service.encontrarCarroPorRenavam(renavam);
    }
    
    public static CarroController getInstance() {
        return controller;
    }
    
    public static void main(String[] args) {
        CarroController controller = CarroController.getInstance();
        
        controller.visualizarInformacoesCarroMenu();
    }
}
