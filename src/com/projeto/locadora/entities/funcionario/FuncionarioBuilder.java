package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;
import com.projeto.locadora.enums.Cargo;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface FuncionarioBuilder extends UsuarioBuilder {
    FuncionarioBuilder senha(String senha);
    FuncionarioBuilder cargo(Cargo cargo);
    Cargo getCargo();
    String getSenha();
    Funcionario build();
}
