package com.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ExemploCollections {

    public static void main(String[] args) {

        List<String> cidades = new ArrayList();
        
        cidades.add("Ijui");
        cidades.add("Panambi");
        cidades.add("Ajuricaba");
        cidades.add("Santo Augusto");
        cidades.add("Tenente Portela");
        cidades.add("Ijui");
        
        System.out.println(cidades);
        
        int x = Collections.frequency(cidades, "Ijui");
        System.out.println("F -> "+x);
        
        Collections.sort(cidades);
        System.out.println(cidades);
        
        Collections.shuffle(cidades);
        System.out.println(cidades);
    }
    
}
