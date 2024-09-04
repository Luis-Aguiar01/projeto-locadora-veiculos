package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface ClienteBuilder extends UsuarioBuilder {
    Cliente build();
}