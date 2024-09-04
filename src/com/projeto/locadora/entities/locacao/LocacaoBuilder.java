package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import java.time.LocalDateTime;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
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
