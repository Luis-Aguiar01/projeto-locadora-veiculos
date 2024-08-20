package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.entities.motor.Motor;
import com.projeto.locadora.enums.Cor;

public interface CarroBuilder {
    CarroBuilder renavam(String renavam);
    CarroBuilder placa(String placa);
    CarroBuilder modelo(Modelo modelo);
    CarroBuilder ano(int ano);
    CarroBuilder cor(Cor cor);
    CarroBuilder quilometragem(double quilometragem);
    CarroBuilder valor(double valor);
    CarroBuilder disponibilidade(DisponibilidadeVeiculo disponibilidade);
    CarroBuilder motor(Motor motor);
    CarroBuilder transmissao(Transmissao transmissao);
    CarroBuilder estadoVeiculo(EstadoVeiculo estadoVeiculo);
    Carro build();
    String getRenavam();
    String getPlaca();
    Modelo getModelo();
    int getAno();
    Cor getCor();
    double getQuilometragem();
    double getValor();
    DisponibilidadeVeiculo getDisponibilidade();
    Motor getMotor();
    Transmissao getTransmissao();
    EstadoVeiculo getEstadoVeiculo();
}
