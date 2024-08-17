package com.projeto.locadora.entities.usuario;

import java.time.LocalDate;

public interface UsuarioBuilder {
    UsuarioBuilder cpf(String cpf);
    UsuarioBuilder nome(String nome);
    UsuarioBuilder email(String email);
    UsuarioBuilder senha(String senha);
    UsuarioBuilder dataNascimento(LocalDate dataNascimento);
    UsuarioBuilder endereco(String endereco);
    UsuarioBuilder telefone(String telefone);
    UsuarioBuilder dataRegistro(LocalDate dataRegistro);
    String getCpf();
    String getNome();
    String getEmail();
    String getSenha();
    LocalDate getDataNascimento();
    String getEndereco();
    String getTelefone();
    LocalDate getDataRegistro();
}
