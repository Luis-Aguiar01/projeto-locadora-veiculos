package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.funcionario.Funcionario;
import java.time.LocalDateTime;

public interface LocacaoBuilder {
    //Setters de atributos
    public LocacaoBuilder setCodigo(Integer codigo);
    public LocacaoBuilder setDataInicio(LocalDateTime dataInicio);
    public LocacaoBuilder setDataFim(LocalDateTime dataFim);
    
    //Setters inter-classes
    public LocacaoBuilder setCliente(Cliente cliente);
    public LocacaoBuilder setFuncionarioCadastro(Funcionario funcionario);
    
    //Getters
    public Integer getCodigo();
    public Cliente getCliente();
    public Funcionario getFuncionarioCadastro();
    public LocalDateTime getDataInicio();
    public LocalDateTime getDataFim();
    public Locacao build();
}
