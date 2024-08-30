package com.projeto.locadora.services.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.pagamento.PagamentoDAO;
import com.projeto.locadora.repositories.pagamento.PagamentoDAOImp;
import java.util.List;

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
