package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.Usuario;
import com.projeto.locadora.services.observer.EventListener;
import java.util.Objects;

/*
    Aplicação do Padrão de Projeto Builder - O Cliente recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.
*/
public class Cliente extends Usuario implements EventListener{
    
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

    @Override
    public void update(String mensagem) {
        System.out.println("Caro senhor(a) " + getNome() + ", " + mensagem + ".");
    }
}
