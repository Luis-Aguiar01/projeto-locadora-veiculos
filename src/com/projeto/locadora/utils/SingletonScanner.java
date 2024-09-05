package com.projeto.locadora.utils;

import java.util.Scanner;

/* 
    A classe SingletonScanner implementa o padrão Singleton para a instância de Scanner, garantindo que apenas uma única instância seja criada e compartilhada ao longo do ciclo de vida do programa. 
    Isso evita a criação de múltiplos objetos Scanner, que podem causar problemas relacionados a recursos, como o uso excessivo de memória ou erros ao tentar fechar o Scanner em diferentes partes do código. 
    Ademais, com o Singleton, o fechamento do Scanner é centralizado, garantindo que ele seja encerrado corretamente apenas em um ponto específico, reduzindo o risco de exceções ao acessar a entrada do sistema várias vezes.

    Resumidamente, essa classe possui uma única instância sua, sendo esta armazenada na própria classe e recebida pelo método getInstance(). O construtor é privado para impedir a criação de objetos da classe.
*/

public class SingletonScanner {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private SingletonScanner(){};
    
    public static Scanner getInstance()
    {
        return scanner;
    } 
}
