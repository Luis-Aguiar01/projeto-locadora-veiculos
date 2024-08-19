package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.Disponibilidade;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.entities.motor.Motor;

public interface CarroBuilder {
    CarroBuilder renavam(String renavam);
    CarroBuilder placa(String placa);
    CarroBuilder modelo(Modelo modelo);
    CarroBuilder ano(int ano);
    CarroBuilder cor(String cor);
    CarroBuilder quilometragem(double quilometragem);
    CarroBuilder valor(double valor);
    CarroBuilder disponibilidade(Disponibilidade disponibilidade);
    CarroBuilder motor(Motor motor);
    CarroBuilder transmissao(Transmissao transmissao);
    CarroBuilder estadoVeiculo(EstadoVeiculo estadoVeiculo);
    Carro build();
    String getRenavam();
    String getPlaca();
    Modelo getModelo();
    int getAno();
    String getCor();
    double getQuilometragem();
    double getValor();
    Disponibilidade getDisponibilidade();
    Motor getMotor();
    Transmissao getTransmissao();
    EstadoVeiculo getEstadoVeiculo();
}
