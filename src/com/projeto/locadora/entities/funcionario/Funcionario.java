package com.projeto.locadora.entities.funcionario;

import com.projeto.locadora.entities.usuario.Usuario;
import java.util.Objects;

public class Funcionario extends Usuario {
    
    private String senha;
    
    public Funcionario(FuncionarioBuilder builder) {
        super(builder);
        this.senha = builder.getSenha();
    }

    public String getSenha() {
        return senha;
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