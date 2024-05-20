package com.acme.sample;

public class MyObject extends Thread {
    
    @Override
    public void run(){
        
        System.out.println("starting MyObject");
        
        while(true) {
            try {
                System.out.println("Executing a search task...");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
    
}
