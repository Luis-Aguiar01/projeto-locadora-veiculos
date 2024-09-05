package com.projeto.locadora.entities.devolucao;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.pagamento.Pagamento;
import java.time.LocalDateTime;

/*
    Aplicação do Padrão de Projeto Builder - A Devolução recebe uma interface do builder,
    ou seja, pode ser inicializado com qualquer implementação concreta dessa interface.
    
    OBS: Assim como as demais entidades, com exceção de Carro e Motor, esta possui 
    um Builder para a criação de instâncias dessa classe. No entanto, o Builder de
    dela apenas fornece um meio de inicializar o objeto personalizado, atributo por atributo,
    sem ter disponível métodos que criam Devoluções com características especificas.
*/
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
