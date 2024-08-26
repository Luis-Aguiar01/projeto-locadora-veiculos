package com.projeto.locadora.controllers.carro;

import com.projeto.locadora.entities.carro.*;
import com.projeto.locadora.entities.motor.*;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.exceptions.*;
import com.projeto.locadora.services.carro.CarroService;
import com.projeto.locadora.utils.*;
import java.util.List;

public class CarroController {
    private final static CarroService service = CarroService.getInstance();
    private final static CarroController controller = new CarroController();
    
    private CarroController() {}
    
    public void exibirOpcoesCarro() {
        int op = 1;
        
        while(op != 4) {
            CarroInterface.printarMenuCarro();
            
            op = ValidarEntradas.validarEntradaInteira("Informe a Opcao Desejada:");
            
            switch (op) {
                case 1 -> cadastrarNovoCarro();
                case 2 -> alterarDadosCarroMenu();
                case 3 -> visualizarInformacoesCarroMenu();
                case 4 -> {}
                default -> System.out.println("Opcao Invalida.");
            }
        }  
    }
    
    public void cadastrarNovoCarro() {
        CarroInterface.printarInterfaceCadastro();
        Carro carro = CarroFactory.criarCarro();
        
        try {
            service.cadastrarCarro(carro);
        }
        catch (RenavamAlreadyRegisteredException renavamException) {
            System.out.println("Carro com o RENAVAM já cadastrado.");
        }
    }
    
    public void alterarDadosCarroMenu() {
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
                    case 8 -> {}
                    default -> System.out.println("Opcao invalida");
                }
            }
            catch(EntityNotFoundException e ) {
                System.out.println("Erro: " + e.getMessage());
            }   
        }
    }
    
    private void alterarCorCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoCor();
        
        Carro carro = encontrarCarroPorRenavam();
        Cor novaCor = OperacoesEnum.validarEnum(Cor.class);
        
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
        DisponibilidadeVeiculo novaDisponibilidade = OperacoesEnum.validarEnum(DisponibilidadeVeiculo.class);
        
        service.alterarDisponibilidadeCarro(carro, novaDisponibilidade);
    }
    
    private void alterarEstadoCarro() throws EntityNotFoundException {
        CarroInterface.printarInterfaceAlteracaoEstado();
        
        Carro carro = encontrarCarroPorRenavam();
        EstadoVeiculo novoEstado = OperacoesEnum.validarEnum(EstadoVeiculo.class);
        
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
    
    public void visualizarInformacoesCarroMenu() {
        int opcao = 1;
       
        while (opcao != 8)  { 
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
                    case 7 -> visualizarCarrosPorMarca();
                    case 8 -> {}
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
        EstadoVeiculo estado = OperacoesEnum.validarEnum(EstadoVeiculo.class);
        List<Carro> carrosPorEstado = service.retornarTodosOsCarrosPorEstado(estado);
        CarroInterface.printarInformacoesCarros(carrosPorEstado);
    }
    
    private void visualizarCarrosPorMarca() {
        Marca marca = OperacoesEnum.validarEnum(Marca.class);
        List<Carro> carrosPorMarca = service.retornarTodosOsCarrosPorMarca(marca);
        CarroInterface.printarInformacoesCarros(carrosPorMarca);
    }
    
    private void visualizarCarrosPorDisponibilidade() {
        DisponibilidadeVeiculo disponibilidade = OperacoesEnum.validarEnum(DisponibilidadeVeiculo.class);
        List<Carro> carrosPorDispobilidade = service.retornarTodosOsCarrosPorDisponibilidade(disponibilidade);
        CarroInterface.printarInformacoesCarros(carrosPorDispobilidade);
    }
    
    private void visualizarCarrosPorCor() {
        Cor cor = OperacoesEnum.validarEnum(Cor.class);
        List<Carro> carrosPorCor = service.retornarTodosOsCarrosPorCor(cor);
        CarroInterface.printarInformacoesCarros(carrosPorCor);
    }
    
    private void visualizarCarrosPorModelo() {
        Modelo modelo = OperacoesEnum.validarEnum(Modelo.class);
        List<Carro> carrosPorModelo = service.retornarTodosOsCarrosPorModelo(modelo);
        CarroInterface.printarInformacoesCarros(carrosPorModelo);
    }
    
    private void visualizarCarrosPorTransmissao() {
        Transmissao transmissao = OperacoesEnum.validarEnum(Transmissao.class);
        List<Carro> carrosPorTransmisao = service.retornarTodosOsCarrosPorTransmissao(transmissao);
        CarroInterface.printarInformacoesCarros(carrosPorTransmisao);
    }

    private Carro encontrarCarroPorRenavam() {
        String renavam = 
                ValidarEntradas.validarEntradaString("Informe o renavam do carro: ", CarroFactory.VALIDAR_RENAVAM_CARRO_REGEX);
        return service.encontrarCarroPorRenavam(renavam);
    }
    
    public static CarroController getInstance() {
        return controller;
    }
    
    public static void main(String[] args) {
        CarroController controller = CarroController.getInstance();
        
        controller.exibirOpcoesCarro();
    }
    
}
