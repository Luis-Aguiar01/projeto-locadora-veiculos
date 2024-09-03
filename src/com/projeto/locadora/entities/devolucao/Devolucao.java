package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.pagamento.Pagamento;
import java.time.LocalDateTime;

public class Devolucao {
    private final int codigo;
    private static int nextCodigo = 1;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataDevolucao;
    private final Pagamento pagamento;
    
    public Devolucao(DevolucaoBuilder builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
     
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataDevolucao = LocalDateTime.now();
        this.pagamento = builder.getPagamento();
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNextCodigo() {
        return nextCodigo;
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
                    ", Funcionário: " + funcionarioCadastro.getNome() + 
                    ", Data devolução: " + dataDevolucao + 
                    ", Pagamento: " + pagamento + 
                '}';
    }
}
