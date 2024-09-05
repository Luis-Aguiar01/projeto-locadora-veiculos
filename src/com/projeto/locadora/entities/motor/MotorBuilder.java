package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores. Utilizada na implementação do padrão
    Builder.
*/
public interface MotorBuilder {
    MotorBuilder potencia(int potencia);
    MotorBuilder volumeCilindros(double volumeCilindros);
    MotorBuilder numeroCilindros(int numeroCilindros);
    MotorBuilder torque(int torque);
    MotorBuilder combustivel(Combustivel combustivel); 
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
