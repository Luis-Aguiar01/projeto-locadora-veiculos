package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.entities.pagamento.Pagamento;
import java.time.LocalDateTime;

public interface DevolucaoBuilder {
    //setters
    public DevolucaoBuilder setLocacao(Locacao locacao);
    public DevolucaoBuilder setFuncionarioCadastro(Funcionario funcionario);
    public DevolucaoBuilder setDataDevolucao(LocalDateTime dataDevolucao);
    public DevolucaoBuilder setPagamento(Pagamento pagamento);
    
    
    //getters
    public Locacao getLocacao();
    public Funcionario getFuncionarioCadastro();
    public LocalDateTime getDataDevolucao();
    public Pagamento getPagamento();
}
