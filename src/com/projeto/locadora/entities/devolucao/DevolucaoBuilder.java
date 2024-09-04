package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.entities.pagamento.Pagamento;

/* 
    Interface base responsável por fornecer todos os métodos do Builder, além dos get's
    para que seja possivel recuperar os valores
*/
public interface DevolucaoBuilder {
    //setters
    public DevolucaoBuilder setLocacao(Locacao locacao);
    public DevolucaoBuilder setFuncionarioCadastro(Funcionario funcionario);
    public DevolucaoBuilder setPagamento(Pagamento pagamento);
    
    //getters
    public Funcionario getFuncionarioCadastro();
    public Pagamento getPagamento();
    
    //build
    public Devolucao build();
}
