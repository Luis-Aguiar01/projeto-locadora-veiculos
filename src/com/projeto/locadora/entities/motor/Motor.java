package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;
import java.util.List;
import java.util.Objects;

public class Motor {
    private final int potencia;
    private final double volumeCilindros;
    private final int torque;
    private final int numeroCilindros;
    private final double consumoCombustivel;
    private final List<Combustivel> combustiveis;
    private final int anoFabricacao;

    public Motor(MotorBuilder motorBuilder) {
        this.potencia = motorBuilder.getPotencia();
        this.volumeCilindros = motorBuilder.getVolumeCilindros();
        this.numeroCilindros = motorBuilder.getNumeroCilindros();
        this.torque = motorBuilder.getTorque();
        this.consumoCombustivel = motorBuilder.getConsumoCombustivel();
        this.combustiveis = motorBuilder.getCombustiveis();
        this.anoFabricacao = motorBuilder.getAnoFabricacao();
    }

    public int getPotencia() {
        return potencia;
    }

    public double getVolumeCilindros() {
        return volumeCilindros;
    }

    public int getTorque() {
        return torque;
    }

    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    public double getConsumoCombustivel() {
        return consumoCombustivel;
    }

    public List<Combustivel> getCombustiveis() {
        return combustiveis;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    @Override
    public String toString() {
        return " Motor = { " +
                "potencia= " + potencia +
                ", volume= " + volumeCilindros +
                ", numeroCilindros= " + numeroCilindros +
                ", torque= " + torque +
                ", combustiveis=" + combustiveis +
                ", consumoCombustivel= "+ consumoCombustivel +
                ", ano= " + anoFabricacao +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motor motor)) return false;
        return getPotencia() == motor.getPotencia() && Double.compare(getVolumeCilindros(), motor.getVolumeCilindros()) == 0 && getTorque() == motor.getTorque() && getNumeroCilindros() == motor.getNumeroCilindros() && Double.compare(getConsumoCombustivel(), motor.getConsumoCombustivel()) == 0 && getAnoFabricacao() == motor.getAnoFabricacao() && Objects.equals(getCombustiveis(), motor.getCombustiveis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPotencia(), getVolumeCilindros(), getTorque(), getNumeroCilindros(), getConsumoCombustivel(), getCombustiveis(), getAnoFabricacao());
    }

    /*public static void main(String[] args) {
        Motor motor = new MotorBuilder()
                .potencia(150)
                .volumeCilindros(2.0)
                .numeroCilindros(4)
                .torque(250)
                .combustiveis(Combustivel.DIESEL, Combustivel.ETANOL)
                .anoFabricacao(2023)
                .consumoCombustivel(8.5)
                .build();

        System.out.println(motor);
    }*/
}
