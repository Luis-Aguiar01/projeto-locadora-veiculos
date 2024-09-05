package com.projeto.locadora.entities.carro;

import com.projeto.locadora.entities.motor.*;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.utils.*;

public class CarroFactory {
    private static final ValidadorString validador = ValidadorString.getInstance();
    
    public static Carro criarCarro() {
        
        validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
        String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
        String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");
        
        validador.setRegex("[A-Za-z0-9-]+");
        String nome = validador.validar("Digite o nome do carro: ");
        
        Modelo modelo = OperacoesEnum.validarEnum(Modelo.class);
        
        Marca marca = OperacoesEnum.validarEnum(Marca.class);
        
        int ano = ValidarEntradasCarro.validarAnoCarro("Digite o ano do carro (maior que 2014): ");
        
        Cor cor = OperacoesEnum.validarEnum(Cor.class);
        
        double quilometragem = ValidarEntradasCarro.validarQuilometragemCarro("Digite a quilometragem do carro: ");
        
        double valorDiaria = ValidarEntradasCarro.validarValorDiariaCarro("Digite o valor da diária do carro (>= 100): ");
        
        Motor motor = MotorFactory.criarMotor();
        
        Transmissao transmissao = OperacoesEnum.validarEnum(Transmissao.class);
                
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome(nome)
                .modelo(modelo)
                .marca(marca)
                .ano(ano)
                .cor(cor)
                .quilometragem(quilometragem)
                .valor(valorDiaria)
                .motor(motor)
                .transmissao(transmissao)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
}
