package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.NumberOutOfRangeException;
import com.projeto.locadora.exceptions.RegexPatternMismatchException;
import java.util.Scanner;

public class ValidarEntradas 
{
    private static final Scanner scanner = new Scanner(System.in);
    
    private static int validarEntradaInteira(String mensagem) 
    {
        int numero = 0;
        boolean condicao = false;
        
        while (!condicao) 
        {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            
            try 
            {
                numero = Integer.parseInt(entrada);
                
                if(numero > 0)
                {
                    condicao = true;
                }
                else
                {
                    throw new NumberOutOfRangeException();
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            }
            catch (NumberOutOfRangeException e)
            {
                System.out.println("Valor inválido. Por favor, digite um número maior que 0.");
            }
        }
        
        return numero;
    }

    private static double validarEntradaDouble(String mensagem) 
    {
        double numero = 0.0;
        boolean condicao = false;
        
        while (!condicao) 
        {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            
            try 
            {
                numero = Double.parseDouble(entrada);
                
                if(numero > 0.0)
                {
                    condicao = true;
                }
                else
                {
                    throw new NumberOutOfRangeException();
                } 
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Entrada inválida. Por favor, digite um número decimal.");
            }
            catch (NumberOutOfRangeException e)
            {
                System.out.println("Valor inválido. Por favor, digite um número maior que 0.0.");
            }
        }
        
        return numero;
    }

    private static String validarEntradaString(String mensagem, String Regex) 
    {
        boolean condicao = false;
        String dado = "";
        
        while(!condicao)
        {
            System.out.print(mensagem);
            dado = scanner.nextLine();
            
            try
            {
                if(dado.matches(Regex))
                {
                    condicao = true;
                }
                else
                {
                    throw new RegexPatternMismatchException();
                }
            }
            catch(RegexPatternMismatchException e)
            {
                System.out.println("Formato Inválido. Por favor, siga o padrão.");
            }
                
        }
        
        return dado;
    }
}
