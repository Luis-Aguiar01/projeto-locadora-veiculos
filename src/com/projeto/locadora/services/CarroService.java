package com.projeto.locadora.services;

import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.enums.Cor;
import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.repositories.carro.CarroDAO;
import com.projeto.locadora.repositories.carro.CarroDAOImp;
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

    public Carro encontrarCarroPorPlaca(String placa) {
        return carroRepositorio.encontrarCarroPorPlaca(placa)
                .orElseThrow(
                        () -> new EntityNotFoundException("Carro com a placa \"" + placa + "\" não encontrado.")
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
    
    public List<Carro> retornarTodosOsCarrosPorCor(String cor) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getCor().equals(cor));
    }
    
    public List<Carro> retornarTodosOsCarrosPorAno(int ano) {
       return carroRepositorio.retornarTodosOsCarrosPorFiltro(c -> c.getAno() == ano);
    }
    
    public void alterarCorCarro(String renavam, Cor novaCor) {
        Carro carro = encontrarCarroPorRenavam(renavam);
        carroRepositorio.alterarCorCarro(carro, novaCor);
    }
    
    public void alterarQuilometragemCarro(String renavam, double novaQuilometragem) {
        Carro carro = encontrarCarroPorRenavam(renavam);
        carroRepositorio.alterarQuilometragemCarro(carro, novaQuilometragem);
    }
    
    public void alterarValorCarro(String renavam, double novoValor) {
        Carro carro = encontrarCarroPorRenavam(renavam);
        carroRepositorio.alterarValorCarro(carro, novoValor);
    }

    public void alterarStatusCarro(String renavam, DisponibilidadeVeiculo novaDisponibilidade) {
        Carro carro = encontrarCarroPorRenavam(renavam);
        carroRepositorio.alterarDisponibilidadeCarro(carro, novaDisponibilidade);
    }

    public static CarroService getInstance() {
        return service;
    }
}
