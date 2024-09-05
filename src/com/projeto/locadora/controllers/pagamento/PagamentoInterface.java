package com.projeto.locadora.controllers.pagamento;

import com.projeto.locadora.entities.pagamento.Pagamento;
import static com.projeto.locadora.utils.OperacoesConsole.GREEN;
import static com.projeto.locadora.utils.OperacoesConsole.RED;
import static com.projeto.locadora.utils.OperacoesConsole.RESET;
import static com.projeto.locadora.utils.OperacoesConsole.limparConsole;
import java.util.List;

public class PagamentoInterface {

    private PagamentoInterface() {}
    
    public static void printarInterfaceCadastro() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||               CADASTRO DE PAGAMENTOS                  ||");
        System.out.println("=============================================================");
        System.out.println("Insira as informacoes do pagamento abaixo:");
    }
    
    public static void printarInformacoesPagamentos(List<Pagamento> pagamentos) {
        limparConsole();
        
        if (pagamentos.isEmpty()) {
            System.out.println(RED + "Nenhum pagamento encontrado." + RESET);
        }
        else {
            System.out.println(GREEN + "\tPagamentos encontrados:\n" + RESET);
            for (Pagamento pagamento : pagamentos) {
                System.out.println(pagamento + "\n");
            }
        }
    }
}
