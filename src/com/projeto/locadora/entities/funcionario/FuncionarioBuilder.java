package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;
import com.projeto.locadora.enums.Cargo;

public interface FuncionarioBuilder extends UsuarioBuilder {
    FuncionarioBuilder senha(String senha);
    FuncionarioBuilder cargo(Cargo cargo);
    Cargo getCargo();
    String getSenha();
    Funcionario build();
}
