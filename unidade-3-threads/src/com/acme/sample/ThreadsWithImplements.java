package com.acme.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

class APP {
    
}

class Printer extends APP implements Runnable {
    
    private int copies;
    private String doc;
    
    public Printer(int copies, String doc) {
        this.copies = copies;
        this.doc = doc;
    }

    @Override
    public void run() {
        for(int i=0; i<copies; i++) {
            System.out.println("Printing doc "+doc+" copy # "+i);
        }
    }
    
}

public class ThreadsWithImplements {

    public static void main(String[] args) {
        
        // Job 1
        System.out.println("-- Starting application --");
        
        // Job 2
        Printer p1 = new Printer(5, "article.pdf");
        Thread t1 = new Thread(p1);  // Criado um objeto runnable
        
        Printer p2 = new Printer(4, "book.pdf");
        Thread t2 = new Thread(p2);
        
        t1.start(); // Pronta para rodar (runnable)
        t2.start();
        
        try {
            Thread.sleep(60000);
        } catch (InterruptedException interruptedException) {
            
        }
    }
    
}
