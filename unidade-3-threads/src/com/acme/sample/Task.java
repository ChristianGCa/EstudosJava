
package com.acme.sample;

public class Task extends Thread {

    private char character;
    
    public Task(char c) {
        character = c;
    }
    
    @Override
    public void run() {
        
        // Imprime na tela e dorme, infinitamente
        while(true) {
            System.out.print(character);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                
            }
            
        }
        
        
    }

    
    
}
    

