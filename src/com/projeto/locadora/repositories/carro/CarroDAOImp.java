package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.exceptions.EntityNotFoundException;
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
    public void excluirCarro(String renavam) {
        Carro carro = getCarro(renavam, "Carro para o renavam informado não encontrado.");
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
    public void alterarDisponibilidadeCarro(String renavam, DisponibilidadeVeiculo novaDisponibilidade) {
        Carro carro = getCarro(renavam, "Carro não encontrado para a troca de disponibilidade.");
        carro.setDisponibilidade(novaDisponibilidade);
        atualizarCarro(renavam, carro);
    }

    @Override
    public void alterarEstadoCarro(String renavam, EstadoVeiculo novoEstado) {
        Carro carro = getCarro(renavam, "Carro não encontrado para a troca de estado.");
        carro.setEstado(novoEstado);
        atualizarCarro(renavam, carro);
    }

    @Override
    public void alterarCorCarro(String renavam, Cor novaCor) {
        Carro carro = getCarro(renavam, "Carro não encontrado para a troca de cor.");
        carro.setCor(novaCor);
        atualizarCarro(renavam, carro);
    }

    @Override
    public void alterarQuilometragemCarro(String renavam, double novaQuilometragem) {
        Carro carro = getCarro(renavam, "Carro não encontrado para a alteração da quilometragem.");
        carro.setQuilometragem(novaQuilometragem);
        atualizarCarro(renavam, carro);
    }

    @Override
    public void alterarValorCarro(String renavam, double novoValor) {
        Carro carro = getCarro(renavam, "Carro não encontrado para a alteração de valor.");
        carro.setValor(novoValor);
        atualizarCarro(renavam, carro);
    }

    private Carro getCarro(String renavam, String msgException) {
        return encontrarCarroPorRenavam(renavam)
                .orElseThrow(
                        () -> new EntityNotFoundException(msgException)
                );
    }

    private void atualizarCarro(String renavam, Carro carro) {
        int carroIndice = encontrarIndiceCarro(renavam);
        carros.set(carroIndice, carro);
    }

    private int encontrarIndiceCarro(String renavam) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getRenavam().equals(renavam)) {
                return i;
            }
        }

        return -1;
    }

    public static CarroDAOImp getInstance() {
        return repository;
    }
}
