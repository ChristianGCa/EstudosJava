package com.acme.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread extends Thread {
    
    @Override
    public void run() {
        
        System.out.println("starting my thread...");
        
        while(true) {
            System.out.println("printing data...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
