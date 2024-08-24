package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;
import com.projeto.locadora.utils.*;

public class MotorFactory {
    public static Motor criarMotor() {
        int potencia = ValidarEntradasMotor.validarPotencia("Insira o valor para a potência do motor (50-300): ");
            
        double volumeCilindros = ValidarEntradasMotor.validarVolumeCilindros("Insira o valor para o volume dos cilindros (1.0-2.5): ");
        
        int torque = ValidarEntradasMotor.validarTorque("Insira o valor para o torque (100-300): ");
        
        int numeroCilindros = ValidarEntradasMotor.validarNumeroCilindros("Insira a quantidade de cilindros (3, 4 ou 6): ");
        
        Combustivel combustivel = OperacoesEnum.validarEnum(Combustivel.class);
        
        double consumoCombustivel = ValidarEntradasMotor.validarConsumoCombustivel("Insira a quantidade do consumo de combustivel (8-20): ");
        
        int anoFabricacao = ValidarEntradasMotor.validarAnoMotor("Insira o ano do motor (maior que 2014): ");
        
        return new MotorBuilderImp()
                .potencia(potencia)
                .volumeCilindros(volumeCilindros)
                .combustivel(combustivel)
                .torque(torque)
                .numeroCilindros(numeroCilindros)
                .consumoCombustivel(consumoCombustivel)
                .anoFabricacao(anoFabricacao)
                .build();
    }
}
