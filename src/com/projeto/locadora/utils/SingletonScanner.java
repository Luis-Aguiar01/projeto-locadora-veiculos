package com.projeto.locadora.utils;

import java.util.Scanner;

public class SingletonScanner {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private SingletonScanner(){};
    
    public static Scanner getInstance()
    {
        return scanner;
    }
    
}
