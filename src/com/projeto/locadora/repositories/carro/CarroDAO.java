package com.projeto.locadora.repositories.carro;

import com.projeto.locadora.enums.DisponibilidadeVeiculo;
import com.projeto.locadora.enums.EstadoVeiculo;
import com.projeto.locadora.entities.carro.Carro;
import com.projeto.locadora.entities.motor.Motor;
import com.projeto.locadora.enums.Cor;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface CarroDAO {
    void cadastrarCarro(Carro carro);
    Optional<Carro> encontrarCarroPorRenavam(String renavam);
    void excluirCarro(Carro carro);
    List<Carro> getAllCars();
    List<Carro> retornarTodosOsCarrosPorFiltro(Predicate<Carro> condition);
    void alterarCorCarro(Carro carro, Cor novaCor);
    void alterarQuilometragemCarro(Carro carro, double novaQuilometragem);
    void alterarValorCarro(Carro carro, double novoValor);
    void alterarDisponibilidadeCarro(Carro carro, DisponibilidadeVeiculo novaDisponibilidade);
    void alterarEstadoCarro(Carro carro, EstadoVeiculo novoEstado);
    void alterarPlacaCarro(Carro carro, String novaPlaca);
    void alterarMotorCarro(Carro carro, Motor novoMotor);
}
