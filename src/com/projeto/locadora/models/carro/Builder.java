package com.projeto.locadora.models.carro;

import com.projeto.locadora.enums.Disponibilidade;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.models.motor.Motor;

public interface Builder {
    Builder renavam(String renavam);
    Builder placa(String placa);
    Builder modelo(Modelo modelo);
    Builder ano(int ano);
    Builder cor(String cor);
    Builder quilometragem(double quilometragem);
    Builder valor(double valor);
    Builder disponibilidade(Disponibilidade disponibilidade);
    Builder motor(Motor motor);
    Builder transmissao(Transmissao transmissao);
    Builder estadoVeiculo(EstadoVeiculo estadoVeiculo);
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
