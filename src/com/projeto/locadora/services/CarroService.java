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
        carroRepositorio.excluirCarro(renavam);
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
        carroRepositorio.alterarCorCarro(renavam, novaCor);
    }
    
    public void alterarQuilometragemCarro(String renavam, double novaQuilometragem) {
        carroRepositorio.alterarQuilometragemCarro(renavam, novaQuilometragem);
    }
    
    public void alterarValorCarro(String renavam, double novoValor) {
        carroRepositorio.alterarValorCarro(renavam, novoValor);
    }

    public void alterarStatusCarro(String renavam, DisponibilidadeVeiculo novaDisponibilidade) {
        carroRepositorio.alterarDisponibilidadeCarro(renavam, novaDisponibilidade);
    }

    public static CarroService getInstance() {
        return service;
    }
}
