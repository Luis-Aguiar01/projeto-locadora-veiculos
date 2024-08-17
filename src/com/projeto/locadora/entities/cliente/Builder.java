package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.UsuarioBuilder;

public interface Builder extends UsuarioBuilder {
    Builder suspenso(boolean suspenso);
    Cliente build();
    boolean getSuspenso();
}