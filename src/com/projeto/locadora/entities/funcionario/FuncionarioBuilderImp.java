package com.projeto.locadora.entities.funcionario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FuncionarioBuilderImp implements FuncionarioBuilder {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private LocalDateTime dataRegistro;

    @Override
    public FuncionarioBuilderImp cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public FuncionarioBuilderImp nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public FuncionarioBuilderImp email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public FuncionarioBuilderImp senha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public FuncionarioBuilderImp dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public FuncionarioBuilderImp endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public FuncionarioBuilderImp telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public FuncionarioBuilderImp dataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
        return this;
    }

    @Override
    public Funcionario build() {
        return new Funcionario(this);
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
    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
