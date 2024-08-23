package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;

public class Motor {
    private final int potencia;
    private final double volumeCilindros;
    private final int torque;
    private final int numeroCilindros;
    private final double consumoCombustivel;
    private final Combustivel combustivel;
    private final int anoFabricacao;

    public Motor(MotorBuilderImp motorBuilder) {
        this.potencia = motorBuilder.getPotencia();
        this.volumeCilindros = motorBuilder.getVolumeCilindros();
        this.numeroCilindros = motorBuilder.getNumeroCilindros();
        this.torque = motorBuilder.getTorque();
        this.consumoCombustivel = motorBuilder.getConsumoCombustivel();
        this.combustivel = motorBuilder.getCombustivel();
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

    public Combustivel getCombustivel() {
        return combustivel;
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
                ", combustiveis=" + combustivel +
                ", consumoCombustivel= "+ consumoCombustivel +
                ", ano= " + anoFabricacao +
                " }";
    }

    /*public static void main(String[] args) {
        Motor motor = new MotorBuilderImp()
                .potencia(150)
                .volumeCilindros(2.0)
                .numeroCilindros(4)
                .torque(250)
                .combustiveis(Combustivel.DIESEL)
                .anoFabricacao(2023)
                .consumoCombustivel(8.5)
                .build();

        System.out.println(motor);
    }*/
}
