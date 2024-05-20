
package com.acme.sample;

public class ThreadWithExtends {

    public static void main(String[] args) {
        
        Task t1 = new Task('.');
        Task t2 = new Task('o');
        Task t3 = new Task('O');
        
        try {
            
            t1.start();
            t2.start();
            t3.start();
            
            Thread.sleep(2 * 60 * 1000);
        } catch (InterruptedException ex) {
            // ignored
        }
        
        t1.stop();
        
        System.out.println("finishing thread main!");
    }
    
}
