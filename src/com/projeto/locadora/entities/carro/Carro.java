package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.*;
import com.projeto.locadora.entities.motor.Motor;
import java.util.Objects;

public class Carro {
    private final String renavam;
    private String placa;
    private final String nome;
    private final Modelo modelo;
    private final Marca marca;
    private final int ano;
    private Cor cor;
    private double quilometragem;
    private double valor;
    private EstadoVeiculo estado;
    private DisponibilidadeVeiculo disponibilidade;
    private Motor motor;
    private final Transmissao transmissao;

    public Carro(CarroBuilder builder) {
        this.renavam = builder.getRenavam();
        this.placa = builder.getPlaca();
        this.nome = builder.getNome();
        this.modelo = builder.getModelo();
        this.marca = builder.getMarca();
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

    public Cor getCor() {
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

    public String getNome() {
        return nome;
    }
    
    public DisponibilidadeVeiculo getDisponibilidade() {
        return disponibilidade;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(Cor cor) {
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

    @Override
    public String toString() {
        return String.format("Carro %s %s\n", nome, marca.getNomeMarca()) +
                "Modelo: " + modelo.getNomeModelo() + "\n" + 
                "Transmissao: " + transmissao.getNomeTransmissao() + "\n" +
                "Volume do Cilindro: " + String.format("%.1f\n", motor.getVolumeCilindros()) +
                "Cor: " + cor.getNomeCor() + "\n" +
                "Valor da Diaria: R$" + valor + "\n" ;
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
}
