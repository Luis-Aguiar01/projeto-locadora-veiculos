package com.projeto.locadora.repositories.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import java.util.*;

/*
    Aplicação do Padrão de Projeto Singleton - O PagamentoDAOImp possui apenas 
    uma única instância da sua classe, que é inicializada como um atributo.
    Essa instância é fornecidada pelo método getInstance().
*/
public class PagamentoDAOImp implements PagamentoDAO {
    private static final List<Pagamento> pagamentos = new ArrayList<>();
    private static final PagamentoDAOImp repositorio = new PagamentoDAOImp();

    private PagamentoDAOImp() {}
    
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
