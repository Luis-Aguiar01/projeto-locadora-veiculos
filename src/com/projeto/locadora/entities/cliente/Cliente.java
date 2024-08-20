package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.Usuario;
import java.util.Objects;

public class Cliente extends Usuario {
    
    public Cliente(ClienteBuilder clienteBuilder) {
        super(clienteBuilder);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return super.getCpf().equals(cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}
