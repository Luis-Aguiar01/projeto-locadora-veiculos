package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.*;
import com.projeto.locadora.entities.carro.*;
import com.projeto.locadora.entities.motor.Motor;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Aplicação do Padrão de Projeto Singleton - O CarroDAOImp possui apenas 
    uma única instância da sua classe, que é inicializada como um atributo.
    Essa instância é fornecidada pelo método getInstance().
*/
public class CarroDAOImp implements CarroDAO {
   
    private static final List<Carro> carros = new ArrayList<>();
    private static final CarroDAOImp repository = new CarroDAOImp();

    private CarroDAOImp() {}

    static {
        Carro carro = new CarroBuilderImp()
                .renavam("11111111111")
                .placa("AAA-0000")
                .modelo(Modelo.CONVERSIVEL)
                .ano(2020)
                .cor(Cor.PRETO)
                .quilometragem(0.0)
                .valor(200.0)
                .transmissao(Transmissao.AUTOMATICO)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .estadoVeiculo(EstadoVeiculo.EM_MANUTENCAO)
                .build();
        
        Carro carro2 = new CarroBuilderImp()
                .renavam("22222222222")
                .placa("BBB-1111")
                .modelo(Modelo.ESPORTIVO)
                .ano(2020)
                .cor(Cor.BRANCO)
                .quilometragem(0.0)
                .valor(200.0)
                .transmissao(Transmissao.SEMI_AUTOMATICO)
                .disponibilidade(DisponibilidadeVeiculo.INDISPONIVEL)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .build();
        
        carros.add(carro);
        carros.add(carro2);
    }
    
    @Override
    public void cadastrarCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public Optional<Carro> encontrarCarroPorRenavam(String renavam) {
        return carros.stream()
                .filter(c -> c.getRenavam().equals(renavam))
                .findFirst();
    }

    @Override
    public void excluirCarro(Carro carro) {
        carros.remove(carro);
    }

    @Override
    public List<Carro> getAllCars() {
        return Collections.unmodifiableList(carros);
    }

    @Override
    public List<Carro> retornarTodosOsCarrosPorFiltro(Predicate<Carro> condition) {
        return carros.stream()
                .filter(condition)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), 
                        Collections::unmodifiableList
                ));
    }

    @Override
    public void alterarDisponibilidadeCarro(Carro carro, DisponibilidadeVeiculo novaDisponibilidade) {
        carro.setDisponibilidade(novaDisponibilidade);
    }

    @Override
    public void alterarEstadoCarro(Carro carro, EstadoVeiculo novoEstado) {
        carro.setEstado(novoEstado);
    }

    @Override
    public void alterarCorCarro(Carro carro, Cor novaCor) {
        carro.setCor(novaCor);
    }

    @Override
    public void alterarQuilometragemCarro(Carro carro, double novaQuilometragem) {
        carro.setQuilometragem(novaQuilometragem);
    }

    @Override
    public void alterarValorCarro(Carro carro, double novoValor) {
        carro.setValor(novoValor);
    }
    
    @Override
    public void alterarPlacaCarro(Carro carro, String novaPlaca) {
        carro.setPlaca(novaPlaca);
    }
    
    @Override
    public void alterarMotorCarro(Carro carro, Motor novoMotor) {
        carro.setMotor(novoMotor);
    }

    public static CarroDAOImp getInstance() {
        return repository;
    }
}
