package com.projeto.locadora.repositories.funcionario;

import com.projeto.locadora.entities.funcionario.Funcionario;
import com.projeto.locadora.entities.funcionario.FuncionarioBuilderImp;
import com.projeto.locadora.enums.Cargo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
    Aplicação do Padrão de Projeto Singleton - O FuncionarioDAOImp possui apenas 
    uma única instância da sua classe, que é inicializada como um atributo.
    Essa instância é fornecidada pelo método getInstance().
*/
public class FuncionarioDAOImp implements FuncionarioDAO{

    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final FuncionarioDAOImp repository = new FuncionarioDAOImp();

    private FuncionarioDAOImp() {}
    
    static {
        Funcionario funcionarioAdm = new FuncionarioBuilderImp()
                .nome("admin")
                .cpf("111.111.111-11")
                .email("admin@admin.com")
                .dataNascimento(LocalDate.of(2000, 12, 31))
                .dataRegistro(LocalDateTime.now())
                .endereco("Av. Aleatório, 213")
                .telefone("(16)99999-9999")
                .senha("admin")
                .cargo(Cargo.ADMIN)
                .build();
        
        Funcionario funcionarioComum = new FuncionarioBuilderImp()
                .nome("Gabriel")
                .cpf("222.222.222-22")
                .email("gabriel@gmail.com")
                .dataNascimento(LocalDate.of(2000, 12, 31))
                .dataRegistro(LocalDateTime.now())
                .endereco("Av. Aleatório, 213")
                .telefone("(16)99999-9999")
                .senha("123")
                .cargo(Cargo.COMUM)
                .build();
        
        funcionarios.add(funcionarioAdm);
        funcionarios.add(funcionarioComum);
    }
    
    @Override
    public Optional<Funcionario> encontrarFuncionarioPorCpf(String cpf) {
        return funcionarios.stream()
                .filter(f -> f.getCpf().equals(cpf))
                .findFirst();
    }
    
    @Override
    public void inserirFuncionario(Funcionario usuario) {
        funcionarios.add(usuario);
    }

    @Override
    public List<Funcionario> getAllFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }
    
    @Override
    public void alterarNomeFuncionario(Funcionario funcionario, String novoNome){
        funcionario.setNome(novoNome);
    }

    @Override
    public void alterarEmailFuncionario(Funcionario funcionario, String novoEmail) {
        funcionario.setEmail(novoEmail);
    }

    @Override
    public void alterarSenha(Funcionario funcionario, String novaSenha) {
        funcionario.setSenha(novaSenha);
    }

    @Override
    public void alterarEnderecoFuncionario(Funcionario funcionario, String novoEndereco) {
        funcionario.setEndereco(novoEndereco);
    }

    @Override
    public void alterarTelefoneFuncionario(Funcionario funcionario, String novoTelefone) {
        funcionario.setTelefone(novoTelefone);
    }
    
    public static FuncionarioDAOImp getInstance() {
        return repository;
    }
}