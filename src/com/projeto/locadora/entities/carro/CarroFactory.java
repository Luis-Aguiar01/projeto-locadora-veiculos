package com.projeto.locadora.entities.carro;

import com.projeto.locadora.entities.motor.*;
import com.projeto.locadora.enums.*;
import com.projeto.locadora.utils.*;
import static com.projeto.locadora.utils.OperacoesConsole.RED;
import static com.projeto.locadora.utils.OperacoesConsole.RESET;
import static com.projeto.locadora.utils.OperacoesConsole.limparConsole;

/*
    Classe responsável por fornecer instâncias prontas para a classe carro,
    além da possibilidade de poder criar um carro personalizado, inicializando o
    mesmo atributo por atributo, com base nas preferências do usuário.
    Essa  classe faz parte da implementação do Padrão Builder, para criar carros de diferentes formas.
*/
public class CarroFactory {
    private static final ValidadorString validador = ValidadorString.getInstance();

    private CarroFactory() {}
    
     public static Carro criarCarro() {
        ValidadorInteiro validadorInteiro = ValidadorInteiro.getInstance();
        int op;
          
        while (true) {
            printarOpcoesCriacaoCarro();
            
            op = validadorInteiro.validar("Informe a Opcao Desejada: ");
            System.out.println("");

            switch (op) {
                case 1 -> {
                    validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
                    String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");

                    validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
                    String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");

                    validador.setRegex(ValidacoesRegex.VALIDAR_NOME_REGEX);
                    String nome = validador.validar("Digite o nome do carro: ");

                    Modelo modelo = OperacoesEnum.validarEnum(Modelo.class);

                    Marca marca = OperacoesEnum.validarEnum(Marca.class);

                    int ano = ValidarEntradasCarro.validarAnoCarro("Digite o ano do carro (maior que 2014): ");

                    Cor cor = OperacoesEnum.validarEnum(Cor.class);

                    double quilometragem = ValidarEntradasCarro.validarQuilometragemCarro("Digite a quilometragem do carro: ");

                    double valorDiaria = ValidarEntradasCarro.validarValorDiariaCarro("Digite o valor da diária do carro (>= 100): ");

                    Motor motor = MotorFactory.criarMotor();

                    Transmissao transmissao = OperacoesEnum.validarEnum(Transmissao.class);

                    return criarCarroPersonalizado(renavam, placa, nome, modelo, marca, ano, cor, quilometragem, valorDiaria, motor, transmissao);
                }
                case 2 -> {
                    return criarCarroPopular();
                }
                case 3 -> {
                    return criarCarroEsportivo();
                }
                case 4 -> {
                    return criarCarroSUV();
                }
                case 5 -> {
                    return criarCamionete();
                }
                default -> System.out.println(RED + "\nOperação inválida. Digite uma opção do menu." + RESET);
            }
        }
    }
     
     public static void printarOpcoesCriacaoCarro() {
        limparConsole();
        System.out.println("=============================================================");
        System.out.println("||                      OPCOES MOTOR                       ||");
        System.out.println("=============================================================");
        System.out.println("|| [1] - Criar Carro Personalizado                   ||");
        System.out.println("|| [2] - Criar Carro Popular                              ||");
        System.out.println("|| [3] - Criar Carro Esportivo                           ||");
        System.out.println("|| [4] - Criar Carro SUV                                   ||");
        System.out.println("|| [5] - Criar Camionete                                   ||");
        System.out.println("=============================================================");
    }
    
    public static Carro criarCarroPersonalizado(String renavam, String placa, String nome, Modelo modelo, 
            Marca marca, int ano, Cor cor, double quilometragem, double valorDiaria, Motor motor, Transmissao transmissao) {
        
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome(nome)
                .modelo(modelo)
                .marca(marca)
                .ano(ano)
                .cor(cor)
                .quilometragem(quilometragem)
                .valor(valorDiaria)
                .motor(motor)
                .transmissao(transmissao)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
    
    public static Carro criarCarroEsportivo() {
        validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
        String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
         String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");
        
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome("Camaro")
                .modelo(Modelo.ESPORTIVO)
                .marca(Marca.CHEVROLET)
                .ano(2024)
                .cor(Cor.PRETO)
                .quilometragem(0.0)
                .valor(200.0)
                .motor(MotorFactory.motorPotenciaAlta())
                .transmissao(Transmissao.AUTOMATICO)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
    
    public static Carro criarCarroPopular() {
        validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
        String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
         String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");
        
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome("Gol")
                .modelo(Modelo.HATCHBACK)
                .marca(Marca.VOLKSWAGEN)
                .ano(2024)
                .cor(Cor.BRANCO)
                .quilometragem(0.0)
                .valor(50.0)
                .motor(MotorFactory.motorPotenciaPopular())
                .transmissao(Transmissao.MANUAL)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
    
    public static Carro criarCarroSUV() {
        validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
        String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
         String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");
        
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome("H-RV")
                .modelo(Modelo.SUV)
                .marca(Marca.HONDA)
                .ano(2024)
                .cor(Cor.PRATA)
                .quilometragem(0.0)
                .valor(100.0)
                .motor(MotorFactory.motorPotenciaMedia())
                .transmissao(Transmissao.AUTOMATICO)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
    
    public static Carro criarCamionete() {
        validador.setRegex(ValidacoesRegex.VALIDAR_RENAVAM_CARRO_REGEX);
        String renavam = validador.validar("Digite o RENAVAM do carro (11 digitos): ");
        
        validador.setRegex(ValidacoesRegex.VALIDAR_PLACA_CARRO_REGEX);
         String placa = validador.validar("Digite a placa do carro (AAA-0000 ou AAA0A00): ");
        
        return new CarroBuilderImp()
                .renavam(renavam)
                .placa(placa)
                .nome("Hillux")
                .modelo(Modelo.CAMIONETE)
                .marca(Marca.TOYOTA)
                .ano(2024)
                .cor(Cor.PRETO)
                .quilometragem(0.0)
                .valor(150.0)
                .motor(MotorFactory.motorPotenciaMedia())
                .transmissao(Transmissao.AUTOMATICO)
                .estadoVeiculo(EstadoVeiculo.MANUTENCAO_EM_DIA)
                .disponibilidade(DisponibilidadeVeiculo.DISPONIVEL)
                .build();
    }
}
