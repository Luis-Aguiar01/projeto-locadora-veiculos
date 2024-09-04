package com.projeto.locadora.entities.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.devolucao.Devolucao;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.multa.Multa;
import com.projeto.locadora.enums.EstadoLocacao;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
    Implementação do Padrão de Projeto Flyweight - Um objeto do tipo locação
    é composto pelas referências de outros objetos, como: Cliente, Carro e Funcionario,
    evitando a multiplicidade dos dados entre os diferentes objetos de locação.
*/
public class Locacao {
    private final Integer codigo;
    private EstadoLocacao estado;
    private final Cliente cliente;
    private final Funcionario funcionarioCadastro;
    private final LocalDateTime dataInicio;
    private final LocalDateTime dataFim;
    private final Carro carro;
    private final List<Multa> multas;
    private Devolucao devolucao;
    
    private static int nextCodigo = 1;
    
    public Locacao(LocacaoBuilder builder) {
        this.codigo = nextCodigo;
        this.nextCodigo++;
        
        this.estado = EstadoLocacao.EM_ABERTO;
        
        this.cliente = builder.getCliente();
        this.funcionarioCadastro = builder.getFuncionarioCadastro();
        this.dataInicio = builder.getDataInicio();
        this.dataFim = builder.getDataFim();
        this.carro = builder.getCarro();
        
        this.multas = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public EstadoLocacao getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public Carro getCarro() {
        return carro;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void adicionarMulta(Multa multa) {
        multas.add(multa);
    }
    
    public void setEstado(EstadoLocacao estado) {
        this.estado = estado;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    @Override
    public String toString() {
        String info = "\n\nLOCACAO\n\n";
        info += "CPF Cliente: " + cliente.getCpf() + ".\n";
        info += "Cadastrado por: " + funcionarioCadastro.getNome() + ".\n";
        info += "Data inicio: " + dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ".\n";
        info += "Data fim: " + dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ".\n";
        info += "Estado: " + estado.getNome()+ ".\n";
        
        info += "\nMULTAS DA LOCACAO:";
        if(!multas.isEmpty()) {
            for(Multa multa : multas) {
                info += "\n\nMotivo multa: " + multa.getDescricao() + ".\n";
                info += "Valor: R$ " + multa.getValor() + ".\n";
            }            
        } else {
            info += " Nenhuma multa aplicada.\n";
        }
        
        return info;
    }

}
