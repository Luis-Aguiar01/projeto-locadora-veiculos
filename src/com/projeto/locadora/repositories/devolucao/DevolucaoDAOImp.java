package com.projeto.locadora.repositories.devolucao;

import com.projeto.locadora.entities.devolucao.Devolucao;
import java.util.ArrayList;
import java.util.List;

/*
    Aplicação do Padrão de Projeto Singleton - O DevolucaoDAOImp possui apenas 
    uma única instância da sua classe, que é inicializada como um atributo.
    Essa instância é fornecidada pelo método getInstance().
*/
public class DevolucaoDAOImp implements DevolucaoDAO {
    
    private static final List<Devolucao> devolucoes = new ArrayList<>();
    private static final DevolucaoDAOImp repositorio = new DevolucaoDAOImp();
    
    private DevolucaoDAOImp() {}
    
    @Override
    public void registrarDevolucao(Devolucao devolucao) {
        devolucoes.add(devolucao);
    }
    
    public static DevolucaoDAOImp getInstance() {
        return repositorio;
    }
}
