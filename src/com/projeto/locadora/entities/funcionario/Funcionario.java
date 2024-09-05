package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.Usuario;
import com.projeto.locadora.enums.Cargo;
import java.util.Objects;

/*
    Aplicação do Padrão de Projeto Builder - Funcionario recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.
    
    OBS: Assim como as demais entidades, com exceção de Carro e Motor, esta possui 
    um Builder para a criação de instâncias dessa classe. No entanto, o Builder de
    dela apenas fornece um meio de inicializar o objeto personalizado, atributo por atributo,
    sem ter disponível métodos que criam Funcionarios com características especificas.
*/
public class Funcionario extends Usuario {
    
    private final Cargo cargo;
    private String senha;
    
    public Funcionario(FuncionarioBuilder builder) {
        super(builder);
        this.senha = builder.getSenha();
        this.cargo = builder.getCargo();
    }

    public String getSenha() {
        return senha;
    }
    
    public Cargo getCargo() {
        return cargo;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
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
}