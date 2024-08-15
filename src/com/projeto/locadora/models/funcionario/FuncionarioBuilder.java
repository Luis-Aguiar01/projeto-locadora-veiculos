package com.projeto.locadora.models.funcionario;

import java.time.LocalDate;
public class FuncionarioBuilder implements Builder {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private LocalDate dataRegistro;

    @Override
    public FuncionarioBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public FuncionarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public FuncionarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public FuncionarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    @Override
    public FuncionarioBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public FuncionarioBuilder endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public FuncionarioBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public FuncionarioBuilder dataRegistro(LocalDate dataRegistro) {
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
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }
}
