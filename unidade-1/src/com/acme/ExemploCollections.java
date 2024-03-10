package com.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploCollections {

    public static void main(String[] args) {
        
        List<String> cidades = new ArrayList();
        
        cidades.add("Ijuí");
        cidades.add("Panambi");
        cidades.add("Ajuricaba");
        cidades.add("Santo augusto");
        cidades.add("Tenente Portela");
        
        System.out.println(cidades);
        
        int x = Collections.frequency(cidades, "Ijuí");
        System.out.println("Frequência -> " + x);
        Collections.sort(cidades);
        System.out.println(cidades);
        
        Collections.shuffle(cidades);
        System.out.println(cidades);
    }
    
}
