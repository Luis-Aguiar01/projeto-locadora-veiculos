package com.projeto.locadora.repositories.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import java.util.*;

public interface PagamentoDAO {
    Optional<Pagamento> encontrarPagamentoPorId(int id); 
    void cadastrarPagamento(Pagamento pagamento);
    List<Pagamento> getAllPagamentos();
}
