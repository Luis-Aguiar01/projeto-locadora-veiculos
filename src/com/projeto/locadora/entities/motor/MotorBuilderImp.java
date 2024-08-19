package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;
import java.util.Arrays;
import java.util.List;

public class MotorBuilderImp implements MotorBuilder{
    private int potencia;
    private double volumeCilindros;
    private int torque;
    private int numeroCilindros;
    private double consumoCombustivel;
    private List<Combustivel> combustiveis;
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
    public MotorBuilder combustiveis(Combustivel... combustiveis) {
        this.combustiveis = Arrays.stream(combustiveis).toList();
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
    public List<Combustivel> getCombustiveis() {
        return combustiveis;
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
