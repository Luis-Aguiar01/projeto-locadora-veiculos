package com.projeto.locadora.models.cliente;

import java.time.LocalDate;

public class ClienteBuilder implements Builder {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private LocalDate dataRegistro;
    private boolean suspenso;

    public ClienteBuilder() {}

    @Override
    public ClienteBuilder suspenso(boolean suspenso) {
        this.suspenso = suspenso;
        return this;
    }

    @Override
    public ClienteBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public ClienteBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public ClienteBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public ClienteBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public ClienteBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public ClienteBuilder endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public ClienteBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public ClienteBuilder dataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
        return this;
    }

    @Override
    public Cliente build() {
        return new Cliente(this);
    }

    @Override
    public boolean getSuspenso() {
        return suspenso;
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
    public String getSenha() {
        return senha;
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
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }
}