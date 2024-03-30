package com.acme;

import java.util.ArrayList;

public class GenericsClass {

    public static void main(String[] args) {

        int[] notas1 = new int[100];
        
        ArrayList<Integer> notas2 = new ArrayList();
        
        notas2.add( 60 );
        notas2.add( 12 );
        notas2.add( 56 );
        
        float m = calcularNotaMedia(notas2);
        System.out.println("Média -> "+m);
        
        Grupo<Integer> g = new Grupo();
        //g.add("Ijui");
        g.add(34);
        //g.add( notas2 );
        
        Grupo<String> g2 = new Grupo();
        g2.add("Ijui");
        
        
        
    }
    
    public static float calcularNotaMedia(ArrayList<Integer> notas) {
        float total = 0f;
        for (Integer n : notas ) {
            total = total + n;
        }
        return ( total / notas.size() );
    }
    
}
