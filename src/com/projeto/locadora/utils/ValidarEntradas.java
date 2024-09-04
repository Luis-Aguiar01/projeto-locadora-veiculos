package com.projeto.locadora.utils;

import com.projeto.locadora.exceptions.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidarEntradas 
{
    private static final Scanner scanner = SingletonScanner.getInstance();
 
    public static LocalDate validarEntradaData(String mensagem) 
    {
        boolean condicao = false;
        LocalDate dataNascimento = null;
        LocalDate dataMinima = LocalDate.now().minusYears(18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        while(!condicao)
        {
            try
            {
                System.out.print(mensagem);
                dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);
                
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
