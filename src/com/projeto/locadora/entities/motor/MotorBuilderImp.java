package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

/* 
    Implementação Concreta da Interface base do Builder.
    Basicamente, fornece uma forma de inicializar todos os
    atributos relavantes do objeto.
*/
public class MotorBuilderImp implements MotorBuilder{
    private int potencia;
    private double volumeCilindros;
    private int torque;
    private int numeroCilindros;
    private double consumoCombustivel;
    private Combustivel combustivel;
    private int anoFabricacao;

    public MotorBuilderImp() {}

    @Override
    public MotorBuilder potencia(int potencia) {
        this.potencia = potencia;
        return this;
    }

    @Override
    public MotorBuilder volumeCilindros(double volumeCilindros) {
        this.volumeCilindros = volumeCilindros;
        return this;
    }

    @Override
    public MotorBuilder numeroCilindros(int numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
        return this;
    }

    @Override
    public MotorBuilder torque(int torque) {
        this.torque = torque;
        return this;
    }

    @Override
    public MotorBuilder combustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
        return this;
    }

    @Override
    public MotorBuilder anoFabricacao(int ano) {
        this.anoFabricacao = ano;
        return this;
    }

    @Override
    public MotorBuilder consumoCombustivel(double consumo) {
        this.consumoCombustivel = consumo;
        return this;
    }

    @Override
    public Motor build() {
        return new Motor(this);
    }

    @Override
    public int getPotencia() {
        return potencia;
    }

    @Override
    public double getVolumeCilindros() {
        return volumeCilindros;
    }

    @Override
    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    @Override
    public int getTorque() {
        return torque;
    }

    @Override
    public Combustivel getCombustivel() {
        return combustivel;
    }

    @Override
    public double getConsumoCombustivel() {
        return consumoCombustivel;
    }

    @Override
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    
}
