package com.acme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploFila {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList();
        
        queue.offer("Ijui");
        queue.offer("Porto Alegre");
        queue.offer("Panambi");
        
        System.out.println(queue);
        
        String v = queue.poll();
        System.out.println(v);
        
        System.out.println(queue);
        
        
    }
    
}
