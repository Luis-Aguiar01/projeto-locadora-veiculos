package com.projeto.locadora;

import com.projeto.locadora.controllers.funcionario.FuncionarioController;
import com.projeto.locadora.utils.SingletonScanner;

public class Application {
    public static void main(String[] args) {
        FuncionarioController controller = FuncionarioController.getInstance();
        
        controller.paginaLogin();
        
        SingletonScanner.getInstance().close();
    }
}
