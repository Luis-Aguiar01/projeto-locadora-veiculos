package com.projeto.locadora.entities.usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface UsuarioBuilder {
    UsuarioBuilder cpf(String cpf);
    UsuarioBuilder nome(String nome);
    UsuarioBuilder email(String email);
    UsuarioBuilder dataNascimento(LocalDate dataNascimento);
    UsuarioBuilder endereco(String endereco);
    UsuarioBuilder telefone(String telefone);
    UsuarioBuilder dataRegistro(LocalDateTime dataRegistro);
    String getCpf();
    String getNome();
    String getEmail();
    LocalDate getDataNascimento();
    String getEndereco();
    String getTelefone();
    LocalDateTime getDataRegistro();
}
