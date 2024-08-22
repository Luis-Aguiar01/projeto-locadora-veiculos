package com.projeto.locadora.utils;

import java.util.Scanner;

public class OperacoesConsole {
        private static Scanner scanner;
    
        public static void limparConsole() {
            for (int i = 0; i < 5; i++) {
                System.out.println();
            }
        }
        
        public static void aguardarEnter() {
            scanner = new Scanner(System.in);
            
            System.out.println("Pressione enter para continuar: ");
            scanner.nextLine();
            
            scanner.close();
        }
}
