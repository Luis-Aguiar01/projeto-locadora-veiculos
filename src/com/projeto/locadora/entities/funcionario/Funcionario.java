package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.Usuario;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

public class Funcionario extends Usuario {

    public Funcionario(FuncionarioBuilder builder) {
        super(builder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario f)) return false;
        return getCpf().equals(f.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Funcionario funcionario = new FuncionarioBuilderImp()
                .cpf("111.111.111-11")
                .nome("João")
                .email("joao@gmail.com")
                .senha("123456")
                .dataNascimento(LocalDateTime.of(2000, Month.MARCH, 10, 10, 10))
                .endereco("Av. Aleatório, 123")
                .telefone("123234421321")
                .dataRegistro(LocalDateTime.now())
                .build();

        System.out.println(funcionario);
    }
}

