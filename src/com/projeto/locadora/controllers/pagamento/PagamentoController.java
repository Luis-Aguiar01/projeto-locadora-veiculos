package com.projeto.locadora.controllers.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import com.projeto.locadora.entities.pagamento.PagamentoFactory;
import com.projeto.locadora.services.pagamento.PagamentoService;
import static com.projeto.locadora.utils.OperacoesConsole.GREEN;
import static com.projeto.locadora.utils.OperacoesConsole.RESET;
import com.projeto.locadora.utils.ValidarEntradas;
import java.util.List;

public class PagamentoController {
    private static final PagamentoService service = PagamentoService.getInstance();
    private static final PagamentoController pagamentoController = new PagamentoController();

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
        int id = ValidarEntradas.validarEntradaInteira("Digite o ID do pagamento:");
        Pagamento pagamento = service.encontrarPagamentoPorId(id);
        
        PagamentoInterface.printarInformacoesPagamentos(List.of(pagamento));
    }
    
    public static PagamentoController getInstance() {
        return pagamentoController;
    }

}
