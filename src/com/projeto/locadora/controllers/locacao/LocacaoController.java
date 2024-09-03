package com.projeto.locadora.controllers.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.devolucao.Devolucao;
import com.projeto.locadora.entities.devolucao.DevolucaoBuilderImp;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.Locacao;
import com.projeto.locadora.entities.locacao.LocacaoBuilderImp;
import com.projeto.locadora.entities.multa.Multa;
import com.projeto.locadora.entities.multa.MultaBuilderImp;
import com.projeto.locadora.entities.pagamento.Pagamento;
import com.projeto.locadora.entities.pagamento.PagamentoBuilderImp;
import com.projeto.locadora.services.carro.CarroService;
import com.projeto.locadora.services.cliente.ClienteService;
import com.projeto.locadora.services.funcionario.FuncionarioService;
import com.projeto.locadora.services.locacao.LocacaoService;
import com.projeto.locadora.utils.ValidadorDouble;
import com.projeto.locadora.utils.ValidadorInteiro;
import com.projeto.locadora.utils.ValidadorString;
import java.time.LocalDateTime;

public class LocacaoController {
    private static final LocacaoService service = LocacaoService.getInstance();
    private static final LocacaoController controller = new LocacaoController();
    private static final ValidadorString validadorString = ValidadorString.getInstance();
    private static final ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
    private static final ValidadorDouble validadorDouble = ValidadorDouble.getInstance();
    private static final FuncionarioService funcionarioService = FuncionarioService.getInstance();
    private static final ClienteService clienteService = ClienteService.getInstance();
    private static final CarroService carroService = CarroService.getInstance();
    
    private LocacaoController() {}
    
    public void cadastrarLocacao() {
        String cpfCliente = validadorString.validar("Digite o CPF do cliente: ");
        
        String cpfFuncionario = validadorString.validar("Digite o CPF do funcionario: ");
        
        String renavam = validadorString.validar("Digite o renavam do carro: ");
        
        Carro carro = carroService.encontrarCarroPorRenavam(renavam);
        
        Funcionario funcionario = funcionarioService.encontrarFuncionarioPorCpf(cpfFuncionario);
        
        Cliente cliente = clienteService.encontrarClientePorCpf(cpfCliente);
        
        int dias = validadorInteiro.validar("Digite a quantidade de dias: ");
        
        Locacao locacao = new LocacaoBuilderImp()
                .setCarro(carro)
                .setCliente(cliente)
                .setDataInicio(LocalDateTime.now())
                .setDataFim(LocalDateTime.now().plusDays(dias))
                .setFuncionarioCadastro(funcionario)
                .build();
        
        service.cadastrarLocacao(locacao);     
    }
    
    public void retornarLocacaoPorId() {
        int id = validadorInteiro.validar("Digite o id da locacao: ");
                
        Locacao locacao = service.retornarLocacaoPorId(id);
        
        System.out.println(locacao);
    }
    
    public void realizarDevolucao() {
        int id = validadorInteiro.validar("Digite o id da locacao: ");
        
        String cpfFuncionario = validadorString.validar("Digite o CPF do funcionario: ");
        
        Funcionario funcionario = funcionarioService.encontrarFuncionarioPorCpf(cpfFuncionario);
                
        Locacao locacao = service.retornarLocacaoPorId(id);
        
//        Pagamento pagamento = new PagamentoBuilderImp()
//                .valor()
//                       
//        Devolucao devolucao = new DevolucaoBuilderImp()
//                .setFuncionarioCadastro(funcionario)
//                .setPagamento()
                
    }

    public void cadastrarMulta() {
         int id = validadorInteiro.validar("Digite o id da locacao: ");
         
         Locacao locacao =  service.retornarLocacaoPorId(id);
         
         double valor = validadorDouble.validar("Digite o valor da multa: ");
         
         String descricao = validadorString.validar("Informe o motivo da multa: ");
         
         Multa multa = new MultaBuilderImp()
                 .valor(valor)
                 .descricao(descricao)
                 .build();
         
         locacao.adicionarMulta(multa);
    }
    
    
    public static LocacaoController getInstance() {
        return controller;
    }
}
