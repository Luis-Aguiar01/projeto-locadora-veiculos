package com.projeto.locadora.entities.carro;

import com.projeto.locadora.enums.*;
import com.projeto.locadora.entities.motor.Motor;

/* 
    Implementação Concreta da Interface base do Builder.
    Basicamente, fornece uma forma sequencial de inicializar todos os
    atributos relevantes do objeto. Utilizada na implementação do padrão
    Builder.
*/
public class CarroBuilderImp implements CarroBuilder {
    private String renavam;
    private String placa;
    private String nome;
    private Modelo modelo;
    private Marca marca;
    private int ano;
    private Cor cor;
    private double quilometragem;
    private double valor;
    private EstadoVeiculo estado;
    private DisponibilidadeVeiculo disponibilidade;
    private Motor motor;
    private Transmissao transmissao;

    public CarroBuilderImp() {}

    @Override
    public String getRenavam() {
        return renavam;
    }
    
    @Override
    public String getPlaca() {
        return placa;
    }
    
    @Override
    public Modelo getModelo() {
        return modelo;
    }
    
    @Override
    public int getAno() {
        return ano;
    }
    
    @Override
    public Cor getCor() {
        return cor;
    }
    
    @Override
    public double getQuilometragem() {
        return quilometragem;
    }
    
    @Override
    public double getValor() {
        return valor;
    }
    
    @Override
    public Motor getMotor() {
        return motor;
    }
    
    @Override
    public Transmissao getTransmissao() {
        return transmissao;
    }
    
    @Override
    public DisponibilidadeVeiculo getDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public EstadoVeiculo getEstadoVeiculo() {
        return estado;
    }
    
    @Override
    public Marca getMarca() {
        return marca;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public CarroBuilder disponibilidade(DisponibilidadeVeiculo disponibilidade) {
        this.disponibilidade = disponibilidade;
        return this;
    }

    @Override
    public CarroBuilder estadoVeiculo(EstadoVeiculo estadoVeiculo) {
        this.estado = estadoVeiculo;
        return this;
    }

    @Override
    public CarroBuilder renavam(String renavam) {
        this.renavam = renavam;
        return this;
    }

    @Override
    public CarroBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }
    
    @Override
    public CarroBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public CarroBuilder modelo(Modelo modelo) {
        this.modelo = modelo;
        return this;
    }
    
    @Override
    public CarroBuilder marca(Marca marca) {
        this.marca = marca;
        return this;
    }

    @Override
    public CarroBuilder ano(int ano) {
        this.ano = ano;
        return this;
    }

    @Override
    public CarroBuilder cor(Cor cor) {
        this.cor = cor;
        return this;
    }

    @Override
    public CarroBuilder quilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
        return this;
    }

    @Override
    public CarroBuilder valor(double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public CarroBuilder motor(Motor motor) {
        this.motor = motor;
        return this;
    }

    @Override
    public CarroBuilder transmissao(Transmissao transmissao) {
        this.transmissao = transmissao;
        return this;
    }

    @Override
    public Carro build() {
        return new Carro(this);
    }
}
