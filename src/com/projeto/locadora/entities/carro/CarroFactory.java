package com.projeto.locadora.entities.carro;

import com.projeto.locadora.entities.motor.*;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.utils.*;

public class CarroFactory {
    public final static String VALIDAR_PLACA_CARRO_REGEX = "([a-zA-Z]{3}-\\d{4})|([a-zA-Z]{3}\\d[a-zA-Z]\\d{2})";
    public final static String VALIDAR_RENAVAM_CARRO_REGEX = "^\\d{11}$";
    
    public static Carro criarCarro() {
        String renavam = ValidarEntradas.validarEntradaString("Digite o renavam do carro: ", VALIDAR_RENAVAM_CARRO_REGEX);
        
        String placa = ValidarEntradas.validarEntradaString("Digite a placa do carro (AAA-0000 ou AAA0A00): ", VALIDAR_PLACA_CARRO_REGEX);
        
        Modelo modelo = ValidarEntradasCarro.validarModelo();
        
        int ano = ValidarEntradasCarro.validarAnoCarro("Digite o ano do carro: ");
        
        Cor cor = ValidarEntradasCarro.validarCorCarro();
        
        double quilometragem = ValidarEntradasCarro.validarQuilometragemCarro("Digite a quilometragem do carro: ");
        
        double valorDiaria = ValidarEntradasCarro.validarValorDiariaCarro("Digite o valor da diária do carro: ");
        
        Motor motor = MotorFactory.criarMotor();
        
        Transmissao transmissao = ValidarEntradasCarro.validarTransmissaoCarro();
                
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .modelo(modelo)
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
