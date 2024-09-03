package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.entities.pagamento.Pagamento;
import java.time.LocalDateTime;

public class DevolucaoBuilderImp implements DevolucaoBuilder {
    private Locacao locacao;
    private Funcionario funcionarioCadastro;
    private LocalDateTime dataDevolucao;
    private Pagamento pagamento;
    
    @Override
    public DevolucaoBuilder setLocacao(Locacao locacao) {
        this.locacao = locacao;
        return this;
    }

    @Override
    public DevolucaoBuilder setFuncionarioCadastro(Funcionario funcionario) {
        this.funcionarioCadastro = funcionario;
        return this;
    }

    @Override
    public DevolucaoBuilder setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        return this;
    }

    @Override
    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    @Override
    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public Pagamento getPagamento() {
        return pagamento;
    }

    @Override
    public Devolucao build() {
        return new Devolucao(this);
    }
}
