package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import java.time.LocalDateTime;

public class Locacao {
    private Integer codigo;
    private Cliente cliente;
    private Funcionario funcionarioCadastro;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    
    
    public Locacao(LocacaoBuilder builder) {
        this.codigo = builder.getCodigo();
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

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCpfCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
        this.funcionarioCadastro = funcionarioCadastro;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
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
