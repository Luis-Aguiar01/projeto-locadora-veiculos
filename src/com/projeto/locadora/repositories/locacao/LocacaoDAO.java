package com.projeto.locadora.repositories.locacao;

import com.projeto.locadora.entities.locacao.Locacao;
import java.util.*;
import java.util.function.Predicate;

public interface LocacaoDAO {
    public void cadastrarLocacao(Locacao locacao);
    public Optional<Locacao> encontrarPorCodigo(int codigo);
    public List<Locacao> obterLocacoes();
    public List<Locacao> obterPorFiltro(Predicate<Locacao> condicao);
}
