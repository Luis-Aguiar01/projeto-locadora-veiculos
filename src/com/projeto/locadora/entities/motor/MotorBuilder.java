package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

public interface MotorBuilder {
    MotorBuilder potencia(int potencia);
    MotorBuilder volumeCilindros(double volumeCilindros);
    MotorBuilder numeroCilindros(int numeroCilindros);
    MotorBuilder torque(int torque);
    MotorBuilder combustivel(Combustivel combustivel); // Passar um ou mais argumentos.
    MotorBuilder anoFabricacao(int ano);
    MotorBuilder consumoCombustivel(double consumo);
    Motor build();
    int getPotencia();
    double getVolumeCilindros();
    int getNumeroCilindros();
    int getTorque();
    Combustivel getCombustivel();
    double getConsumoCombustivel();
    int getAnoFabricacao();
}
