package com.projeto.locadora.services;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.motor.Motor;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.carro.*;
import java.util.List;

public class CarroService {
    private static final CarroDAO carroRepositorio = CarroDAOImp.getInstance();
    private static final CarroService service = new CarroService();

    private CarroService() {}

    public void cadastrarCarro(Carro carro) {
        carroRepositorio.cadastrarCarro(carro);
    }

    public Carro encontrarCarroPorRenavam(String renavam) {
        return carroRepositorio.encontrarCarroPorRenavam(renavam)
                .orElseThrow(
                        () -> new EntityNotFoundException("Carro com renavam " + renavam + " não encontrado.")
                );
    }

    public void excluirCarro(String renavam) {
        Carro carro = encontrarCarroPorRenavam(renavam);
        carroRepositorio.excluirCarro(carro);
    }

    public List<Carro> retornarTodosOsCarros() {
        return carroRepositorio.getAllCars();
    }

    public List<Carro> retornarTodosOsCarrosPorModelo(Modelo modelo) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getModelo().equals(modelo) );
    }
    
    public List<Carro> retornarTodosOsCarrosPorDisponibilidade(DisponibilidadeVeiculo disponibilidade) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getDisponibilidade().equals(disponibilidade));
    }
    
    public List<Carro> retornarTodosOsCarrosPorEstado(EstadoVeiculo estado) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getEstado().equals(estado));
    }
    
    public List<Carro> retornarTodosOsCarrosPorCor(Cor cor) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getCor().equals(cor));
    }
    
    public List<Carro> retornarTodosOsCarrosPorAno(int ano) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getAno() == ano);
    }
    
    public List<Carro> retornarTodosOsCarrosPorTransmissao(Transmissao transmissao) {
        return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getTransmissao().equals(transmissao));
    }
    
    public void alterarCorCarro(Carro carro, Cor novaCor) {
        carroRepositorio.alterarCorCarro(carro, novaCor);
    }
    
    public void alterarQuilometragemCarro(Carro carro, double novaQuilometragem) {
        carroRepositorio.alterarQuilometragemCarro(carro, novaQuilometragem);
    }
    
    public void alterarValorCarro(Carro carro, double novoValor) {
        carroRepositorio.alterarValorCarro(carro, novoValor);
    }

    public void alterarDisponibilidadeCarro(Carro carro, DisponibilidadeVeiculo novaDisponibilidade) {
        carroRepositorio.alterarDisponibilidadeCarro(carro, novaDisponibilidade);
    }
    
    public void alterarEstadoCarro(Carro carro, EstadoVeiculo novoEstado) {
        carroRepositorio.alterarEstadoCarro(carro, novoEstado);
    }
    
    public void alterarPlacaCarro(Carro carro, String novaPlaca) {
        carroRepositorio.alterarPlacaCarro(carro, novaPlaca);
    }
    
    public void alterarMotorCarro(Carro carro, Motor novoMotor) {
        carroRepositorio.alterarMotorCarro(carro, novoMotor);
    }

    public static CarroService getInstance() {
        return service;
    }
}
