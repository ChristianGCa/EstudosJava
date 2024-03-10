package com.acme;

import java.util.Collection;
import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {
        
        HashMap<Integer, String> estudantes = new HashMap();
        
        // Adicionando estudantes
        estudantes.put(1, "Ryder");
        estudantes.put(2, "Carl Johnson");
        estudantes.put(3, "Big Smoke");
        
        // Adicionando registro com a mesma chave ja usada (Não da erro, apenasm sobrescreve)
        estudantes.put(2, "Sweet");
        
        System.out.println("Size -> " + estudantes.size());
        
        // Armazenando a coleção de dados retornados para mostrar na tela com um laço
        Collection<String> values = estudantes.values();
        
        for(String n: values) {
            System.out.println(n);
        }
        
        System.out.println(estudantes.keySet());
        
        Collection<Integer> keys = estudantes.keySet();
        for(Integer v: keys) {
            System.out.println(v);
        }
        
    }    
}
