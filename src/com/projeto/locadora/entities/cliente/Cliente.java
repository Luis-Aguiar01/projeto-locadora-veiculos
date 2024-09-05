package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.Usuario;
import com.projeto.locadora.entities.cliente.observer.EventListener;
import java.util.Objects;

/*
    Implementação do Padrão de Projeto Observer - A classe cliente
    implementa a interface EventListener, que, basicamente, fornece
    um método para enviar uma mensagem para um Cliente.

    OBS: Assim como as demais entidades, Cliente possui um Builder
    para a criação de instâncias dessa classe. No entanto, o Builder de
    cliente apenas fornece um meio de inicializar o objeto personalizado,
    sem ter disponível métodos que criam clientes com características
    especificas.
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
