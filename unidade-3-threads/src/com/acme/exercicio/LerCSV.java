package com.acme.exercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {
    
    public static void main(String[] args) {
        
        String path = "/home/christian/Downloads/social-distancing-cities.csv";
        String city = "Ijuí";
        System.out.println("Quantidade de linhas totais: "+howManyLines(path));
        System.out.println("Quantidade de linhas para "+city+": "+howManyLinesWithCity(path, city));
    }
    
    public static Integer howManyLines(String path) {
    
        try {
            // Acessa e lê o arquivo
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader buffer = new BufferedReader(fr);
            
            // Se é diferente de null, é porque ainda tem linhas pra ler
            int contador = 0;
            while( (buffer.readLine()) != null ) {
                contador += 1;
            }
            buffer.close();
            fr.close();
            return contador;
        
        }catch(IOException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        return null;
    }
    
    public static Integer howManyLinesWithCity(String path, String city) {
    
        try {
            // Acessa e lê o arquivo
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader buffer = new BufferedReader(fr);
            
            // Se é diferente de null, é porque ainda tem linhas pra ler
            int contador = 0;
            String line;
            while((line = buffer.readLine()) != null ) {
                if (line.contains(city)) {
                    contador += 1;
                }
            }
            buffer.close();
            fr.close();
            return contador;
        
        }catch(IOException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        return null;
    }
    
}
