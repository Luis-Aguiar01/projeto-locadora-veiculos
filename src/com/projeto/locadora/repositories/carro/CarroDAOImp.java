package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.enums.Cor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarroDAOImp implements CarroDAO {
    private static final List<Carro> carros = new ArrayList<>();
    private static final CarroDAOImp repository = new CarroDAOImp();

    private CarroDAOImp() {}

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
    public Optional<Carro> encontrarCarroPorPlaca(String placa) {
        return carros.stream()
                .filter(c -> c.getPlaca().equalsIgnoreCase(placa))
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

    public static CarroDAOImp getInstance() {
        return repository;
    }
}
