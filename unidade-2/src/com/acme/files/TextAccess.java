package com.acme.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextAccess {

    public static void main(String[] args) {
        
        // Chama o método readTextFile para ler o conteúdo de um arquivo de texto e imprime o conteúdo
        String text = readTextFile("/home/christian/mydata/mydata.ser");
        System.out.println("text");
    }
    
    //Método genérico
    public static String readTextFile(String fileName) {
    
        try {
            
            ////////////////////////////
            // ESTUDAR ESSAS CLASSSES //
            ////////////////////////////
            
            // Acessa e lê o arquivo
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader buffer = new BufferedReader(fr);
            StringBuilder text = new StringBuilder();
            String line = "";
            
            // Cada linha lida é adicionada a um objeto StringBuilder para formar o texto completo.
            // Se é diferente de null, é porque ainda tem linhas pra ler
            while( (line = buffer.readLine()) != null ) {
                text.append(line);
                text.append("\n");
            }
            buffer.close();
            fr.close();
            return text.toString();
        
        }catch(Exception ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        return null;
    }
}
