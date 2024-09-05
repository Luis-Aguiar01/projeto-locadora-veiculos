package com.projeto.locadora.services.funcionario;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.exceptions.CpfAlreadyRegisteredException;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.funcionario.FuncionarioDAO;
import com.projeto.locadora.repositories.funcionario.FuncionarioDAOImp;
import com.projeto.locadora.utils.FormatarDados;
import java.util.List;

/*
    Implementação do Padrão de Projeto Singleton - Todas as classes services possuem
    apenas uma única instância sua, sendo esta armazenada na classe e recebida pelo 
    método getInstance(). O construtor é privado para impedir a criação de objetos da classe.
*/

public class FuncionarioService {
    
    private static final FuncionarioDAO funcionarioRepositorio = FuncionarioDAOImp.getInstance();
    private static final FuncionarioService service = new FuncionarioService();

    private FuncionarioService() {}
    
    public Funcionario encontrarFuncionarioPorCpf(String cpf) throws EntityNotFoundException{
        return funcionarioRepositorio.encontrarFuncionarioPorCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException("Funcionário com o CPF: \"" + cpf + "\" não encontrado.")               
                );
    }
    
    public boolean checarCpf(Funcionario funcionario){
        return funcionarioRepositorio.getAllFuncionarios()
                .stream()
                .anyMatch(f -> f.getCpf().equals(funcionario.getCpf()));
    }
    
    public void inserirFuncionario(Funcionario funcionario) throws CpfAlreadyRegisteredException{
        if (!checarCpf(funcionario)) {
            String nome = funcionario.getNome();
            
            nome = FormatarDados.formatarNome(nome);
            
            funcionario.setNome(nome);
            
            funcionarioRepositorio.inserirFuncionario(funcionario);
        } 
        else {
            throw new CpfAlreadyRegisteredException("Usuario com CPF já cadastrado.");
        }        
    }
    
    public List<Funcionario> retornarTodosOsFuncionarios(){
        return funcionarioRepositorio.getAllFuncionarios();
    }
    
    public void alterarNomeFuncionario(Funcionario funcionario, String novoNome){
        funcionarioRepositorio.alterarNomeFuncionario(funcionario, novoNome);
    }
    
    public void alterarEmailFuncionario(Funcionario funcionario, String novoEmail){
        funcionarioRepositorio.alterarEmailFuncionario(funcionario, novoEmail);
    }
    
    public void alterarEnderecoFuncionario(Funcionario funcionario, String novoEndereco){
        funcionarioRepositorio.alterarEnderecoFuncionario(funcionario, novoEndereco);
    }
    
    public void alterarTelefoneFuncionario(Funcionario funcionario, String novoTelefone){
        funcionarioRepositorio.alterarTelefoneFuncionario(funcionario, novoTelefone);
    }
    
    public void alterarSenhaFuncionario(Funcionario funcionario, String novaSenha){
        funcionarioRepositorio.alterarSenha(funcionario, novaSenha);
    }
    
    public static FuncionarioService getInstance(){
        return service;
    }
}
