package com.projeto.locadora.repositories.locacao;

import com.projeto.locadora.entities.locacao.Locacao;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocacaoDAOImp implements LocacaoDAO {
    private static final List<Locacao> locacoes = new ArrayList<>();
    private static final LocacaoDAOImp repositorio = new LocacaoDAOImp();
    
    private LocacaoDAOImp() {}
    
    @Override
    public void cadastrarLocacao(Locacao locacao) {
        locacoes.add(locacao);
    }

    @Override
    public Optional<Locacao> encontrarPorCodigo(int codigo) {
        Optional<Locacao> locacao = locacoes.stream()
                .filter(loc -> loc.getCodigo() == codigo)
                .findFirst();
        
        return locacao;
    }

    @Override
    public List<Locacao> obterLocacoes() {
        return Collections.unmodifiableList(locacoes);
    }

    @Override
    public List<Locacao> obterPorFiltro(Predicate<Locacao> condicao) {
        List<Locacao> locacoesFiltradas = locacoes.stream()
                .filter(condicao)
                .collect(Collectors.toList());
        
        return Collections.unmodifiableList(locacoesFiltradas);
    }
    
     public static LocacaoDAOImp getInstance() {
        return repositorio;
    }
}
