package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ValidarEntradas 
{
    private static final Scanner scanner = new Scanner(System.in);
    
    public static int validarEntradaInteira(String mensagem) 
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

    public static double validarEntradaDouble(String mensagem) 
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

    public static String validarEntradaString(String mensagem, String regex) 
    {
        boolean condicao = false;
        String dado = "";
        
        while(!condicao)
        {
            System.out.print(mensagem);
            dado = scanner.nextLine();
            
            try
            {
                if(dado.matches(regex))
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
    
    public static LocalDate validarEntradaData(String mensagem) 
    {
        boolean condicao = false;
        LocalDate dataNascimento = null;
        LocalDate dataMinima = LocalDate.now().minusYears(18); 
        
        while(!condicao)
        {
            try
            {
                System.out.print(mensagem);
                dataNascimento = LocalDate.parse(scanner.nextLine());
                
                if(dataNascimento.isBefore(dataMinima) || dataNascimento.isEqual(dataMinima))
                {
                    condicao = true;
                }
                else
                {
                    throw new MinimumAgeRequirementException();
                }
            }
            catch(DateTimeException e)
            {
                System.out.println("Formato Inválido. Por favor, siga o padrão.");
            }  
            catch(MinimumAgeRequirementException e)
            {
                System.out.println("Data Inválida. O cliente deve ter pelo menos 18 anos completos.");
            }
        }
        
        return dataNascimento;
    }
}
