package com.projeto.locadora.repositories.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import java.util.List;
import java.util.Optional;

public interface PagamentoDAO {
    Optional<Pagamento> encontrarPagamentoPorId(int id); 
    void cadastrarPagamento(Pagamento pagamento);
    List<Pagamento> getAllPagamentos();
}
