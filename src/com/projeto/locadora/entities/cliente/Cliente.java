package com.projeto.locadora.entities.cliente;

import com.projeto.locadora.entities.usuario.Usuario;
import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Usuario {
    private final int codigoCliente;
    private boolean suspenso;
    private static int nextCodigo = 1;

    public Cliente(Builder clienteBuilder) {
        super(clienteBuilder);

        this.codigoCliente = nextCodigo;
        this.suspenso = clienteBuilder.getSuspenso();
        nextCodigo++;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    @Override
    public String toString() {
        return super.toString() + ", codigoCliente= " + codigoCliente + ", suspenso= " + suspenso + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getCodigoCliente() == cliente.getCodigoCliente();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoCliente());
    }

    public static void main(String[] args) {
        Cliente cliente = new ClienteBuilder()
                .cpf("1")
                .nome("Luis")
                .email("luis@gmail.com")
                .senha("123")
                .dataNascimento(LocalDate.now())
                .endereco("Av. Aleatorio, 123")
                .telefone("123123231")
                .dataRegistro(LocalDate.now())
                .build();

        System.out.println(cliente);
    }
}
