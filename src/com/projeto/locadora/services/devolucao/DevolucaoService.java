package com.projeto.locadora.services.devolucao;

import com.projeto.locadora.repositories.devolucao.DevolucaoDAO;
import com.projeto.locadora.repositories.devolucao.DevolucaoDAOImp;

public class DevolucaoService {
    private static final DevolucaoDAO repositorio = DevolucaoDAOImp.getInstance();
    private static final DevolucaoService service = new DevolucaoService();
    
    private DevolucaoService() {}
    
    
    
    
    
    
    
    public static DevolucaoService getInstance() {
        return service;
    }
}
