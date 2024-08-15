package com.projeto.locadora.models.funcionario;

import com.projeto.locadora.models.usuario.Usuario;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Usuario {

    private final int codigoFuncionario;
    private static int nextId = 1;

    public Funcionario(Builder builder) {
        super(builder);

        this.codigoFuncionario = nextId;
        nextId++;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        return getCodigoFuncionario() == that.getCodigoFuncionario();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoFuncionario());
    }

    @Override
    public String toString() {
        return super.toString() + ", codigoFuncionario=" + codigoFuncionario + " }";
    }

    public static void main(String[] args) {
        Funcionario funcionario = new FuncionarioBuilder()
                .cpf("111.111.111-11")
                .nome("João")
                .email("joao@gmail.com")
                .senha("123456")
                .dataNascimento(LocalDate.of(2000, 4, 21))
                .endereco("Av. Aleatório, 123")
                .telefone("123234421321")
                .dataRegistro(LocalDate.now())
                .build();

        System.out.println(funcionario);
    }
}

