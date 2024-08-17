package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.Disponibilidade;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.enums.Modelo;
import com.projeto.locadora.enums.Transmissao;
import com.projeto.locadora.entities.carro.Carro;
import java.util.List;
import java.util.Optional;

public interface CarroDAO {
    void cadastrarCarro(Carro carro);
    Optional<Carro> encontrarCarroPorRenavam(String renavam);
    Optional<Carro> encontrarCarroPorPlaca(String placa);
    void excluirCarro(String renavam);
    List<Carro> getAllCars();
    List<Carro> getAllCarsByModelo(Modelo modelo);
    List<Carro> getAllCarsByDisponibilidade(Disponibilidade disponibilidade);
    List<Carro> getAllCarsByEstado(EstadoVeiculo estado);
    List<Carro> getAllCarsByTransmissao(Transmissao transmissao);
    void alterarCorCarro(String renavam, String novaCor);
    void alterarQuilometragemCarro(String renavam, double novaQuilometragem);
    void alterarValorCarro(String renavam, double novoValor);
    void alterarDisponibilidadeCarro(String renavam, Disponibilidade novaDisponibilidade);
    void alterarEstadoCarro(String renavam, EstadoVeiculo novoEstado);
}
