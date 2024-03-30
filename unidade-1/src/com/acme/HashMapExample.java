package com.acme;

import java.util.Collection;
import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer,String> estudantes = new HashMap();
        
        estudantes.put(1, "João Pedro");
        estudantes.put(2, "Manuel Gomes");
        estudantes.put(3, "Maria Julia");
        
        estudantes.put(2, "Beto");
        
        System.out.println( "Size -> "+estudantes.size() );
        
        Collection<String> values = estudantes.values();
        
        for(String n: values) {
            System.out.println(n);
        }
        
    }
    
}
