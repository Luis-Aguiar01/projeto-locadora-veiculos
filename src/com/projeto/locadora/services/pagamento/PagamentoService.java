package com.projeto.locadora.services.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.pagamento.*;
import java.util.List;

/*
    Implementação do Padrão de Projeto Singleton - Todas as classes services possuem
    apenas uma única instância sua, sendo esta armazenada na classe e recebida pelo 
    método getInstance(). O construtor é privado para impedir a criação de objetos da classe.
*/

public class PagamentoService {
    
    private static final PagamentoDAO pagamentoRepositorio = PagamentoDAOImp.getInstance();
    private static final PagamentoService service = new PagamentoService();

    private PagamentoService() {}
    
    public Pagamento encontrarPagamentoPorId(int id) throws EntityNotFoundException{
        return pagamentoRepositorio.encontrarPagamentoPorId(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Pagamento com o ID: \"" + id + "\" não encontrado.")
                );
    }
    
    public void cadastrarPagamento(Pagamento pagamento){
        pagamentoRepositorio.cadastrarPagamento(pagamento);
    }
    
    public List<Pagamento> retornarTodosOsPagamentos(){
        return pagamentoRepositorio.getAllPagamentos();
    }
    
    public static PagamentoService getInstance(){
        return service;
    }
}
