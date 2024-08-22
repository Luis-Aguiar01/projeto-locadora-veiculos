package com.projeto.locadora.entities.motor;

import com.projeto.locadora.utils.ValidarEntradas;
import com.projeto.locadora.utils.ValidarEntradasMotor;

public class MotorFactory {
    public static Motor criarMotor() {
        int potencia = ValidarEntradas.validarEntradaInteira("Insira o valor para a potência do motor: ");
            
        double volumeCilindros = ValidarEntradas.validarEntradaDouble("Insira o valor para o volume dos cilindros: ");
        
        int torque = ValidarEntradas.validarEntradaInteira("Insira o valor para o torque: ");
        
        int numeroCilindros = ValidarEntradas.validarEntradaInteira("Insira a quantidade de cilindros: '");
        
        double consumoCombustivel = ValidarEntradas.validarEntradaDouble("Insira a quantidade de km/L: ");
        
        int anoFabricacao = ValidarEntradasMotor.validarAnoMotor("Insira o ano do motor: ");
        
        return new MotorBuilderImp()
                .potencia(potencia)
                .volumeCilindros(volumeCilindros)
                .torque(torque)
                .numeroCilindros(numeroCilindros)
                .consumoCombustivel(consumoCombustivel)
                .anoFabricacao(anoFabricacao)
                .build();
    }
}
