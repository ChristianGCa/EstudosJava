package com.acme;

public class TestPrint {

    public static void main(String[] args) {

        PrintActivity p1 = new PrintActivity("register");
        System.out.println( "ID -> "+p1.getId() );
        
        PrintActivity p2 = new PrintActivity();
        
        // Só atribui nome se (name.length() >=4 && name.length() <=10)
        p2.setName("12345678912");
        
        System.out.println("Name P2 -> "+p2.getName() );

    }
    
}
