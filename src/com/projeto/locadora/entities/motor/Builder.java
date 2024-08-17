package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

import java.util.List;

public interface Builder {
    Builder potencia(int potencia);
    Builder volumeCilindros(double volumeCilindros);
    Builder numeroCilindros(int numeroCilindros);
    Builder torque(int torque);
    Builder combustiveis(Combustivel ...combustiveis); // Passar um ou mais argumentos.
    Builder anoFabricacao(int ano);
    Builder consumoCombustivel(double consumo);
    Motor build();
    int getPotencia();
    double getVolumeCilindros();
    int getNumeroCilindros();
    int getTorque();
    List<Combustivel> getCombustiveis();
    double getConsumoCombustivel();
    int getAnoFabricacao();
}
