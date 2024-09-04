package com.projeto.locadora.controllers.locacao;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.cliente.Cliente;
import com.projeto.locadora.entities.devolucao.*;
import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.locacao.*;
import com.projeto.locadora.entities.multa.*;
import com.projeto.locadora.entities.pagamento.*;
import com.projeto.locadora.enums.EstadoLocacao;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.services.carro.CarroService;
import com.projeto.locadora.services.cliente.ClienteService;
import com.projeto.locadora.services.funcionario.FuncionarioService;
import com.projeto.locadora.services.locacao.LocacaoService;
import com.projeto.locadora.utils.*;
import static com.projeto.locadora.utils.OperacoesConsole.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

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
    
    public void menuLocacao() {       
        int op = 1;
        
        try {
            while (op != 5) {
                LocacaoInterface.printarMenuLocacao();

                op = validadorInteiro.validar("Informe a Opcao Desejada: ");

                switch (op) {
                    case 1 ->
                        cadastrarLocacao();
                    case 2 ->
                        cadastrarMulta();
                    case 3 ->
                        realizarDevolucao();
                    case 4 ->
                        retornarLocacaoPorId();
                    case 5 -> {
                    }
                    default ->
                        System.out.println(RED + "\nOperacao invalida. Digite uma opcao do menu." + RESET);
                }
            }
        }
        catch (EntityNotFoundException e) {
            System.out.println(RED + "\nErro: " + e.getMessage() + RESET);
        }
        
    }
    
    public void cadastrarLocacao() throws EntityNotFoundException
    {
        LocacaoInterface.printarInterfaceCadastro();
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_CPF_REGEX);
        
        String cpfCliente = validadorString.validar("Digite o CPF do cliente: ");
        
        String cpfFuncionario = validadorString.validar("Digite o CPF do funcionario: ");
        
        validadorString.setRegex("\\d{11}");
        
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
        LocacaoInterface.printarInterfaceConsultaLocacao();
        
        int id = validadorInteiro.validar("Digite o id da locacao: ");
                
        Locacao locacao = service.retornarLocacaoPorId(id);
        
        System.out.println(locacao);
    }
    
    public void realizarDevolucao() throws EntityNotFoundException
    {   
        LocacaoInterface.printarInterfaceDevolucao();
        
        int id = validadorInteiro.validar("Digite o id da locacao: ");
        
        Locacao locacao = service.retornarLocacaoPorId(id);
        
        validadorString.setRegex(ValidacoesRegex.VALIDAR_CPF_REGEX);
        
        String cpfFuncionario = validadorString.validar("Digite o CPF do funcionario: ");
        
        Funcionario funcionario = funcionarioService.encontrarFuncionarioPorCpf(cpfFuncionario);
                
        if(LocalDate.now().isAfter(locacao.getDataFim().toLocalDate()))
        {
            long diasAtraso = ChronoUnit.DAYS.between(LocalDate.now(), locacao.getDataFim());
            Multa multa = new MultaBuilderImp()
                    .valor(diasAtraso * (locacao.getCarro().getValor() + locacao.getCarro().getValor() * 0.50))
                    .descricao("Devolucao Realizada Apos a Data Estipulada.")
                    .build();
            
            locacao.adicionarMulta(multa);
        }
        
        locacao.setEstado(EstadoLocacao.FINALIZADA);
       
        Pagamento pagamento = new PagamentoBuilderImp()
                .valor(service.somarTotal(locacao))
                .build();
                       
        Devolucao devolucao = new DevolucaoBuilderImp()
                .setFuncionarioCadastro(funcionario)
                .setPagamento(pagamento)
                .build();
                
    }

    public void cadastrarMulta() throws EntityNotFoundException 
    {
        LocacaoInterface.printarInterfaceMulta();
        
        int id = validadorInteiro.validar("Digite o id da locacao: ");
         
        Locacao locacao =  service.retornarLocacaoPorId(id);
         
        double valor = validadorDouble.validar("Digite o valor da multa: ");
         
        validadorString.setRegex(ValidacoesRegex.VALIDAR_CAMPO_TEXTO_REGEX);
        
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
    
    public static void main(String[] args) {
        
        controller.cadastrarLocacao();
        
        controller.retornarLocacaoPorId();
        
        controller.realizarDevolucao();
        
        controller.retornarLocacaoPorId();
        
    }
}
