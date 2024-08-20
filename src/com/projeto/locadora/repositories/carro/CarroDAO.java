package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.enums.Cor;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CarroDAO {
    void cadastrarCarro(Carro carro);
    Optional<Carro> encontrarCarroPorRenavam(String renavam);
    Optional<Carro> encontrarCarroPorPlaca(String placa);
    void excluirCarro(String renavam);
    List<Carro> getAllCars();
    List<Carro> retornarTodosOsCarrosPorFiltro(Predicate<Carro> condition);
    void alterarCorCarro(String renavam, Cor novaCor);
    void alterarQuilometragemCarro(String renavam, double novaQuilometragem);
    void alterarValorCarro(String renavam, double novoValor);
    void alterarDisponibilidadeCarro(String renavam, DisponibilidadeVeiculo novaDisponibilidade);
    void alterarEstadoCarro(String renavam, EstadoVeiculo novoEstado);
}
