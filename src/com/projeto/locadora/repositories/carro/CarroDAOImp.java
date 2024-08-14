package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.Disponibilidade;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.exceptions.EntityNotFoundException;
import com.projeto.locadora.models.carro.Carro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public List<Carro> getAllCarsByModelo(Modelo modelo) {
        return carros.stream()
                .filter(c -> c.getModelo().equals(modelo))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
    }

    @Override
    public List<Carro> getAllCarsByTransmissao(Transmissao transmissao) {
        return carros.stream()
                .filter(c -> c.getTransmissao().equals(transmissao))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
    }
    
    @Override
    public List<Carro> getAllCarsByDisponibilidade(Disponibilidade disponibilidade) {
        return carros.stream()
                .filter(c -> c.getDisponibilidade().equals(disponibilidade))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
    }

    @Override
    public List<Carro> getAllCarsByEstado(EstadoVeiculo estado) {
        return carros.stream()
                .filter(c -> c.getEstado().equals(estado))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
    }

    @Override
    public void alterarDisponibilidadeCarro(String renavam, Disponibilidade novaDisponibilidade) {
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
    public void alterarCorCarro(String renavam, String novaCor) {
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
