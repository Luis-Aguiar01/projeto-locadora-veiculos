package com.projeto.locadora.repositories.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PagamentoDAOImp implements PagamentoDAO {
    private static final List<Pagamento> pagamentos = new ArrayList<>();
    private static final PagamentoDAOImp repositorio = new PagamentoDAOImp();

    @Override
    public Optional<Pagamento> encontrarPagamentoPorId(int id) {
        Optional<Pagamento> pagamento = pagamentos.stream()
                .filter(pag -> pag.getCodigo() == id)
                .findFirst();
        
        return pagamento;
    }

    @Override
    public void cadastrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    @Override
    public List<Pagamento> getAllPagamentos() {
        return Collections.unmodifiableList(pagamentos);
    }
    
    public static PagamentoDAOImp getInstance() {
        return repositorio;
    }
}
