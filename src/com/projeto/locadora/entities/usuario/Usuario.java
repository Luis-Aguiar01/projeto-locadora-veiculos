package com.projeto.locadora.entities.usuario;

import java.time.LocalDate;

public abstract class Usuario {
    private final String cpf;
    private final String nome;
    private String email;
    private String senha;
    private final LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private final LocalDate dataRegistro;

    protected Usuario(UsuarioBuilder usuarioBuilder) {
        this.cpf = usuarioBuilder.getCpf();
        this.nome = usuarioBuilder.getNome();
        this.email = usuarioBuilder.getEmail();
        this.senha = usuarioBuilder.getSenha();
        this.dataNascimento = usuarioBuilder.getDataNascimento();
        this.endereco = usuarioBuilder.getEndereco();
        this.telefone = usuarioBuilder.getTelefone();
        this.dataRegistro = usuarioBuilder.getDataRegistro();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public String toString() {
        return "{ " + "cpf= " + cpf +
                ", nome= " + nome +
                ", email= " + email +
                ", senha= " + senha +
                ", dataNascimento= " + dataNascimento +
                ", endereco= " + endereco +
                ", telefone= " + telefone +
                ", dataRegistro= " + dataRegistro;
    }
}
