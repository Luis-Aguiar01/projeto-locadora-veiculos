package com.projeto.locadora.entities.motor;

import com.projeto.locadora.enums.Combustivel;
import com.projeto.locadora.utils.*;
import static com.projeto.locadora.utils.OperacoesConsole.RED;
import static com.projeto.locadora.utils.OperacoesConsole.RESET;
import static com.projeto.locadora.utils.OperacoesConsole.limparConsole;

/*
    Classe responsável por fornecer instâncias prontas para a classe Motor,
    além da possibilidade de poder criar um Motor personalizado, inicializando o
    mesmo atributo por atributo, com base nas preferências do usuário.
    Essa  classe faz parte da implementação do Padrão Builder, para criar motores de diferentes formas.
*/
public class MotorFactory 
{   
    public static Motor criarMotor() 
    {
        ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
        int op;
        
        Motor motor;
        
        while (true)
        {
            printarOpcoesCriacaoMotor();
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            System.out.println("");

            switch (op) {
                case 1 -> 
                {
                    int potencia = ValidarEntradasMotor.validarPotencia("Insira o valor para a potência do motor (50 - 300): ");

                    double volumeCilindros = ValidarEntradasMotor.validarVolumeCilindros("Insira o valor para o volume dos cilindros (1.0 - 3.0): ");

                    int torque = ValidarEntradasMotor.validarTorque("Insira o valor para o torque (10 - 200): ");

                    int numeroCilindros = ValidarEntradasMotor.validarNumeroCilindros("Insira a quantidade de cilindros (3, 4, 5 ou 6): ");

                    Combustivel combustivel = OperacoesEnum.validarEnum(Combustivel.class);

                    double consumoCombustivel = ValidarEntradasMotor.validarConsumoCombustivel("Insira a quantidade do consumo de combustivel (3 - 20): ");

                    int anoFabricacao = ValidarEntradasMotor.validarAnoMotor("Insira o ano do motor (maior que 2014): ");

                    return motorPersonalizado(potencia, volumeCilindros, numeroCilindros, torque, combustivel, anoFabricacao, consumoCombustivel);
                }
                case 2 ->
                {
                    return motorPotenciaPopular();
                }
                case 3 ->
                {
                    return motorPotenciaMedia();
                }
                case 4 ->
                {
                    return motorPotenciaAlta();
                }
                default -> System.out.println(RED + "\nOperação inválida. Digite uma opção do menu." + RESET);
            }
        }
    }
    
    public static void printarOpcoesCriacaoMotor() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                      OPCOES MOTOR                       ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Criar Motor Personalizado                         ||");
        System.out.println("|| [2] - Motor Potencia Popular                            ||");
        System.out.println("|| [3] - Motor Potencia Media                              ||");
        System.out.println("|| [4] - Motor Potencia Alta                               ||");
        System.out.println("=============================================================");
    }
    
    public static Motor motorPersonalizado(int potencia, double volumeCilindros, int numeroCilindros, int torque, Combustivel combustivel, int anoFabricacao, double consumoCombustivel)
    {
        return new MotorBuilderImp().potencia(potencia)
                .volumeCilindros(volumeCilindros)
                .numeroCilindros(numeroCilindros)
                .torque(torque)
                .combustivel(combustivel)
                .anoFabricacao(anoFabricacao)
                .consumoCombustivel(consumoCombustivel)
                .build();
    }
    
    public static Motor motorPotenciaPopular()
    {
        return new MotorBuilderImp().potencia(100)
                .volumeCilindros(1.0)
                .numeroCilindros(3)
                .torque(20)
                .combustivel(Combustivel.FLEX)
                .anoFabricacao(2023)
                .consumoCombustivel(10)
                .build();
    }
    
    public static Motor motorPotenciaMedia()
    {
        return new MotorBuilderImp().potencia(200)
                .volumeCilindros(2.0)
                .numeroCilindros(4)
                .torque(30)
                .combustivel(Combustivel.FLEX)
                .anoFabricacao(2023)
                .consumoCombustivel(6.5)
                .build();
    }
    
    public static Motor motorPotenciaAlta()
    {
        return new MotorBuilderImp().potencia(220)
                .volumeCilindros(3.0)
                .numeroCilindros(4)
                .torque(45)
                .combustivel(Combustivel.GASOLINA)
                .anoFabricacao(2023)
                .consumoCombustivel(6)
                .build();
    }
    
}
