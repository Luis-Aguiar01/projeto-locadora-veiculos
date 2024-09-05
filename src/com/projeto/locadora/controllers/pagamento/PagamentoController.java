package com.projeto.locadora.controllers.pagamento;

import com.projeto.locadora.entities.pagamento.*;
import com.projeto.locadora.services.pagamento.PagamentoService;
import static com.projeto.locadora.utils.OperacoesConsole.*;
import com.projeto.locadora.utils.ValidadorInteiro;
import java.util.List;

/*
    Implementação do Padrão de Projeto Singleton - Todas as classes controllers possuem
    apenas uma única instância sua, sendo esta armazenada na classe e recebida pelo 
    método getInstance(). O construtor é privado para impedir a criação de objetos da classe.
*/
public class PagamentoController {
    private static final PagamentoService service = PagamentoService.getInstance();
    private static final PagamentoController pagamentoController = new PagamentoController();
    private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();

    private PagamentoController() {}
    
    public void cadastrarPagamento() {
        PagamentoInterface.printarInterfaceCadastro();
        
        Pagamento pagamento = PagamentoFactory.criarPagamento();
        
        service.cadastrarPagamento(pagamento);
        
        System.out.println(GREEN + "\nPagamento Cadastrado com Sucesso." + RESET);
    }
    
    public void listarPagamento() {
        List<Pagamento> listaPagamentos = service.retornarTodosOsPagamentos();
        PagamentoInterface.printarInformacoesPagamentos(listaPagamentos);
    }
    
    public void encontrarPagamento() {
        int id = validadorInteiro.validar("Digite o ID do pagamento:");
        Pagamento pagamento = service.encontrarPagamentoPorId(id);
        
        PagamentoInterface.printarInformacoesPagamentos(List.of(pagamento));
    }
    
    public static PagamentoController getInstance() {
        return pagamentoController;
    }

}
