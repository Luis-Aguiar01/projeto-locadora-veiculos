package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.Usuario;
import java.time.LocalDateTime;
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

    public static void main(String[] args) {
        Cliente cliente = new ClienteBuilderImp()
                .cpf("1")
                .nome("Luis")
                .email("luis@gmail.com")
                .dataNascimento(LocalDateTime.now())
                .endereco("Av. Aleatorio, 123")
                .telefone("123123231")
                .dataRegistro(LocalDateTime.now())
                .build();

        System.out.println(cliente);
    }
}
