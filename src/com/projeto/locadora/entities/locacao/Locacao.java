package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import java.time.LocalDateTime;

public class Locacao {
    private final Integer codigo;
    private final Cliente cliente;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataInicio;
    private final LocalDateTime dataFim;
    
    private int nextCodigo = 1;
    
    public Locacao(LocacaoBuilder builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
        
        this.cliente = builder.getCliente();
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataInicio = builder.getDataInicio();
        this.dataFim = builder.getDataFim();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    
    @Override
    public String toString() {
        String info = "LOCAÇÃO\n\n";
        info += "CPF Cliente: " + cliente.getCpf() + "\n";
        info += "Cadastrado por: " + funcionarioCadastro.getNome() + "\n";
        info += "Data início: " + dataInicio + "\n";
        info += "Data fim: " + dataFim + "\n";
        return info;
    }
}
