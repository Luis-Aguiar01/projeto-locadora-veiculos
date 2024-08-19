package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;

public interface ClienteBuilder extends UsuarioBuilder {
    Cliente build();
}