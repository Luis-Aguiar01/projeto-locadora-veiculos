package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.enums.EstadoLocacao;
import java.time.LocalDateTime;

public class Locacao {
    private final Integer codigo;
    private static int nextCodigo = 1;
    
    private EstadoLocacao estado;
    
    private final Cliente cliente;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataInicio;
    private final LocalDateTime dataFim;
    
    
    public Locacao(LocacaoBuilder builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
        
        this.estado = EstadoLocacao.EM_ABERTO;
        
        this.cliente = builder.getCliente();
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataInicio = builder.getDataInicio();
        this.dataFim = builder.getDataFim();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public EstadoLocacao getEstado() {
        return estado;
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

    public void setEstado(EstadoLocacao estado) {
        this.estado = estado;
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
