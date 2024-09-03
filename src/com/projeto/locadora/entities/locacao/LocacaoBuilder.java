package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.multa.Multa;
import java.time.LocalDateTime;

public interface LocacaoBuilder {
    //Setters de atributos
    public LocacaoBuilder setDataInicio(LocalDateTime dataInicio);
    public LocacaoBuilder setDataFim(LocalDateTime dataFim);
    public LocacaoBuilder setCarro(Carro carro);
    
    //Setters inter-classes
    public LocacaoBuilder setCliente(Cliente cliente);
    public LocacaoBuilder setFuncionarioCadastro(Funcionario funcionario);
    
    //Getters
    public Cliente getCliente();
    public Funcionario getFuncionarioCadastro();
    public LocalDateTime getDataInicio();
    public LocalDateTime getDataFim();
    public Carro getCarro();
    public Locacao build();
}
