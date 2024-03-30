package com.acme;

public class TestPrint {

    public static void main(String[] args) {

        PrintActivity p1 = new PrintActivity("register");
        System.out.println( "ID -> "+p1.getId() );
        
        PrintActivity p2 = new PrintActivity();
        p2.setName("compute tax");
        
        System.out.println("Name P2 -> "+p2.getName() );

    }
    
}
