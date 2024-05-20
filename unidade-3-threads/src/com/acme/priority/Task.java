package com.acme.priority;

public class Task extends Thread {
    
    // Atributes
    private int id;
    private char character;
    private int[] executions;
    
    // Constructor
    public Task(int id, int[] executions) {
        this.id = id;
        this.executions = executions;
    }

    @Override
    public void run() {
        
        System.out.println("starting thread #"+id);
        
        while(true) {
            executions[id] = executions[id] + 1;
        }
        
    }
    
    
    
}
