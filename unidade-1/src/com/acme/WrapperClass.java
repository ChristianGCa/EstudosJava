package com.acme;

public class WrapperClass {

    public static void main(String[] args) {

        String q = "47";
        String p = "2.87";
        
        int qq = Integer.parseInt(q);
        float pp = Float.parseFloat(p);
        
        float total = qq * pp;
        System.out.println(total);
        
        System.out.println("Maior Inteiro (32 bits) -> "+ Integer.MAX_VALUE );
        System.out.println("Maior Longo   (64 bits) -> "+ Long.MAX_VALUE );
        System.out.println("Maior Double  (64 bits) -> "+ Double.MAX_VALUE );
    }
    
}
