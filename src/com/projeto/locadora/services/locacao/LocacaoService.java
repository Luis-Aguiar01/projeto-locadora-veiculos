package com.projeto.locadora.services.locacao;

import com.projeto.locadora.entities.devolucao.Devolucao;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.locacao.*;
import java.time.temporal.ChronoUnit;

public class LocacaoService {
    private static final LocacaoDAO repositorio = LocacaoDAOImp.getInstance();
    private static final LocacaoService service = new LocacaoService();
    
    private LocacaoService() {}
    
    public void cadastrarLocacao(Locacao locacao) {
        repositorio.cadastrarLocacao(locacao);
    }
    
    public Locacao retornarLocacaoPorId(int id) {
        return repositorio.encontrarPorCodigo(id)
                .orElseThrow(() -> new EntityNotFoundException("Nao existe locacao com esse id."));
    }
    
    public void realizarDevolucao(Devolucao devolucao, int id) {
        Locacao locacao = retornarLocacaoPorId(id);
        locacao.setDevolucao(devolucao);
    }
    
    public double somarMultas(Locacao locacao) {
        return locacao.getMultas().stream()
                .mapToDouble(m -> m.getValor())
                .sum();
    }
    
    public double somarTotal(Locacao locacao) 
    {
        long diasComum = ChronoUnit.DAYS.between(locacao.getDataFim(), locacao.getDataInicio());
        
        return (diasComum * locacao.getCarro().getValor()) + somarMultas(locacao);
    }
    
    public static LocacaoService getInstance() {
        return service;
    }
}
