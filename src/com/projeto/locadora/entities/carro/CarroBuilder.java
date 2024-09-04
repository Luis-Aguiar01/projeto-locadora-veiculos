package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.*;
import com.projeto.locadora.entities.motor.Motor;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
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
    CarroBuilder marca(Marca marca);
    CarroBuilder nome(String nome);
    Carro build();
    String getRenavam();
    String getPlaca();
    String getNome();
    Modelo getModelo();
    Marca getMarca();
    int getAno();
    Cor getCor();
    double getQuilometragem();
    double getValor();
    DisponibilidadeVeiculo getDisponibilidade();
    Motor getMotor();
    Transmissao getTransmissao();
    EstadoVeiculo getEstadoVeiculo();
}
