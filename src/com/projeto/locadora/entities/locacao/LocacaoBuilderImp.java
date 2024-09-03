package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import java.time.LocalDateTime;

public class LocacaoBuilderImp implements LocacaoBuilder {
    private Cliente cliente;
    private Funcionario funcionarioCadastro;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Carro carro;

    @Override
    public LocacaoBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    @Override
    public LocacaoBuilder setFuncionarioCadastro(Funcionario funcionario) {
        this.funcionarioCadastro = funcionario;
        return this;
    }

    @Override
    public LocacaoBuilder setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    @Override
    public LocacaoBuilder setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }
    
    @Override
    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    @Override
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    @Override
    public LocalDateTime getDataFim() {
        return dataFim;
    }
    
    @Override
    public LocacaoBuilder setCarro(Carro carro) {
        this.carro = carro;
        return this;
    }

    @Override
    public Carro getCarro() {
        return carro;
    }

    @Override
    public Locacao build() {
        return new Locacao(this);
    }
}
