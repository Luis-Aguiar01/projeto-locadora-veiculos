package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.devolucao.Devolucao;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.multa.Multa;
import com.projeto.locadora.enums.EstadoLocacao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
    private final Integer codigo;
    private EstadoLocacao estado;
    private final Cliente cliente;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataInicio;
    private final LocalDateTime dataFim;
    private final Carro carro;
    private final List<Multa> multas;
    private Devolucao devolucao;
    
    private static int nextCodigo = 1;
    
    public Locacao(LocacaoBuilder builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
        
        this.estado = EstadoLocacao.EM_ABERTO;
        
        this.cliente = builder.getCliente();
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataInicio = builder.getDataInicio();
        this.dataFim = builder.getDataFim();
        this.carro = builder.getCarro();
        
        this.multa = new ArrayList<>();
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

    public Carro getCarro() {
        return carro;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void adicionarMulta(Multa multa) {
        multas.add(multa);
    }
    
    public void setEstado(EstadoLocacao estado) {
        this.estado = estado;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
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
