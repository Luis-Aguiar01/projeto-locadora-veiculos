package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

import java.util.List;

public interface MotorBuilder {
    MotorBuilder potencia(int potencia);
    MotorBuilder volumeCilindros(double volumeCilindros);
    MotorBuilder numeroCilindros(int numeroCilindros);
    MotorBuilder torque(int torque);
    MotorBuilder combustiveis(Combustivel ...combustiveis); // Passar um ou mais argumentos.
    MotorBuilder anoFabricacao(int ano);
    MotorBuilder consumoCombustivel(double consumo);
    Motor build();
    int getPotencia();
    double getVolumeCilindros();
    int getNumeroCilindros();
    int getTorque();
    List<Combustivel> getCombustiveis();
    double getConsumoCombustivel();
    int getAnoFabricacao();
}
