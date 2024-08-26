package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.entities.pagamento.Pagamento;
import java.time.LocalDateTime;

public class Devolucao {
    private final int codigo;
    private int nextCodigo = 1;
    
    private final Locacao locacao;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataDevolucao;
    private final Pagamento pagamento;
    
    public Devolucao(DevolucaoBuilderImp builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
        
        this.locacao = builder.getLocacao();
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataDevolucao = builder.getDataDevolucao();
        this.pagamento = builder.getPagamento();
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNextCodigo() {
        return nextCodigo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    @Override
    public String toString() {
        return "Devolucao{" + 
                    "Código: " + codigo + 
                    ", Locação: " + locacao.getCodigo() + 
                    ", Funcionário: " + funcionarioCadastro.getNome() + 
                    ", Data devolução: " + dataDevolucao + 
                    ", Pagamento: " + pagamento + 
                '}';
    }
}
