package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;

public interface FuncionarioBuilder extends UsuarioBuilder {
    FuncionarioBuilder senha(String senha);
    String getSenha();
    Funcionario build();
}
