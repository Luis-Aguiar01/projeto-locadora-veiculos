package com.projeto.locadora.entities.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteBuilderImp implements ClienteBuilder {
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private LocalDateTime dataRegistro;

    public ClienteBuilderImp() {}

    @Override
    public ClienteBuilderImp cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public ClienteBuilderImp nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public ClienteBuilderImp email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public ClienteBuilderImp dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public ClienteBuilderImp endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public ClienteBuilderImp telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public ClienteBuilderImp dataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
        return this;
    }

    @Override
    public Cliente build() {
        return new Cliente(this);
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}