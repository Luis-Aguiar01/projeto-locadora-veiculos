package com.projeto.locadora.models.cliente;

import com.projeto.locadora.models.usuario.UsuarioBuilder;

public interface Builder extends UsuarioBuilder {
    Builder suspenso(boolean suspenso);
    Cliente build();
    boolean getSuspenso();
}