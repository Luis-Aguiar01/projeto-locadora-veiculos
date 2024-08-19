package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.entities.motor.Motor;
import com.projeto.locadora.enums.Transmissao;
import java.util.Objects;

public class Carro {
    private final String renavam;
    private String placa;
    private final Modelo modelo;
    private final int ano;
    private String cor;
    private double quilometragem;
    private double valor;
    private EstadoVeiculo estado;
    private DisponibilidadeVeiculo disponibilidade;
    private Motor motor;
    private Transmissao transmissao;

    public Carro(CarroBuilder builder) {
        this.renavam = builder.getRenavam();
        this.placa = builder.getPlaca();
        this.modelo = builder.getModelo();
        this.ano = builder.getAno();
        this.cor = builder.getCor();
        this.quilometragem = builder.getQuilometragem();
        this.valor = builder.getValor();
        this.estado = builder.getEstadoVeiculo();
        this.disponibilidade = builder.getDisponibilidade();
        this.motor = builder.getMotor();
        this.transmissao = builder.getTransmissao();
    }

    public String getRenavam() {
        return renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public double getValor() {
        return valor;
    }

    public Motor getMotor() {
        return motor;
    }

    public Transmissao getTransmissao() {
        return transmissao;
    }

    public EstadoVeiculo getEstado() {
        return estado;
    }

    public DisponibilidadeVeiculo getDisponibilidade() {
        return disponibilidade;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setEstado(EstadoVeiculo estado) {
        this.estado = estado;
    }

    public void setDisponibilidade(DisponibilidadeVeiculo disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setTransmissao(Transmissao transmissao) {
        this.transmissao = transmissao;
    }

    @Override
    public String toString() {
        return "Carro{" + 
                "renavam=" + renavam + 
                ", placa=" + placa + 
                ", modelo=" + modelo + 
                ", ano=" + ano + 
                ", cor=" + cor + 
                ", quilometragem=" + quilometragem + 
                ", valor=" + valor + 
                ", estado=" + estado + 
                ", disponibilidade=" + disponibilidade + 
                ", motor=" + motor + 
                ", transmissao=" + transmissao + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro carro)) return false;
        return Objects.equals(getRenavam(), carro.getRenavam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRenavam());
    }
    
    public static void main(String[] args) {
        Carro c = new CarroBuilderImp()
                .cor("Azul")
                .ano(2022)
                .build();
        
        System.out.println(c);
    }
}
