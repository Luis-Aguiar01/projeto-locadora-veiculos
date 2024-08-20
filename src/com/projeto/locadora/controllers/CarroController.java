package com.projeto.locadora.controllers;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.carro.CarroBuilderImp;
import com.projeto.locadora.entities.motor.Motor;
import com.projeto.locadora.entities.motor.MotorBuilderImp;
import com.projeto.locadora.enums.Cor;
import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.services.CarroService;
import com.projeto.locadora.utils.ValidarEntradas;
import com.projeto.locadora.utils.ValidarEntradasCarro;
import com.projeto.locadora.utils.ValidarEntradasMotor;
import java.util.Scanner;

public class CarroController {
    private final static CarroService service = CarroService.getInstance();
    private final static CarroController controller = new CarroController();
    private final static Scanner scanner = new Scanner(System.in);

    private CarroController() {}
    
    public static void cadastrarNovoCarro() {
        System.out.println("=========================================================");
        System.out.println("||               CADASTRAR NOVO VEÍCULO                ||");
        System.out.println("=========================================================");
       
        String renavam = ValidarEntradas.validarEntradaString("Digite o renavam do carro: ", "^\\d{11}$");
        
        String placa = ValidarEntradas.validarEntradaString("Digite a placa do carro (AAA-0000 ou AAA0A00): ", "([a-zA-Z]{3}-\\d{4})|([a-zA-Z]{3}\\d[a-zA-Z]\\d{2})");
        
        Modelo modelo = ValidarEntradasCarro.validarModelo();
        
        int ano = ValidarEntradasCarro.validarAnoCarro("Digite o ano do carro: ");
        
        Cor cor = ValidarEntradasCarro.validarCorCarro();
        
        double quilometragem = ValidarEntradasCarro.validarQuilometragemCarro("Digite a quilometragem do carro: ");
        
        double valorDiaria = ValidarEntradasCarro.validarValorDiariaCarro("Digite o valor da diária do carro: ");
        
        Motor motor = criarMotor();
        
        Transmissao transmissao = ValidarEntradasCarro.validarTransmissaoCarro();
        
        Carro carro = new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .modelo(modelo)
                .ano(ano)
                .cor(cor)
                .quilometragem(quilometragem)
                .valor(valorDiaria)
                .motor(motor)
                .transmissao(transmissao)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .build();
        
        System.out.println(carro);
    }
    
    private static Motor criarMotor() {
        int potencia = ValidarEntradas.validarEntradaInteira("Insira o valor para a potência do motor: ");
            
        double volumeCilindros = ValidarEntradas.validarEntradaDouble("Insira o valor para o volume dos cilindros: ");
        
        int torque = ValidarEntradas.validarEntradaInteira("Insira o valor para o torque: ");
        
        int numeroCilindros = ValidarEntradas.validarEntradaInteira("Insira a quantidade de cilindros: '");
        
        double consumoCombustivel = ValidarEntradas.validarEntradaDouble("Insira a quantidade de km/L: ");
        
        int anoFabricacao = ValidarEntradasMotor.validarAnoMotor("Insira o ano do motor: ");
        
        Motor motor = new MotorBuilderImp()
                .potencia(potencia)
                .volumeCilindros(volumeCilindros)
                .torque(torque)
                .numeroCilindros(numeroCilindros)
                .consumoCombustivel(consumoCombustivel)
                .anoFabricacao(anoFabricacao)
                .build();
        
        return motor;
    }

    public static CarroController getInstance() {
        return controller;
    }
    
    public static void main(String[] args) {
        cadastrarNovoCarro();
    }
}
