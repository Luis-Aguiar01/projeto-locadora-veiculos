package com.projeto.locadora.entities.usuario;

import java.time.*;
import java.time.format.DateTimeFormatter;

/*
    Aplicação do Padrão de Projeto Builder - O Usuário recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.
*/
public abstract class Usuario {
    private final String cpf;
    private String nome;
    private String email;
    private final LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private final LocalDateTime dataRegistro;

    protected Usuario(UsuarioBuilder usuarioBuilder) {
        this.cpf = usuarioBuilder.getCpf();
        this.nome = usuarioBuilder.getNome();
        this.email = usuarioBuilder.getEmail();
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
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public String toString() {
        return ""
                + "Nome Completo: " + nome + ".\n"
                + "CPF: " + cpf + ".\n"
                + "Data de Nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ".\n"
                + "Email: " + email + ".\n"
                + "Telefone: " + telefone + ".\n"
                + "Endereco: " + endereco + ".\n"
                + "Data e Horario de Registro: " + dataRegistro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ".\n";
    }
}
