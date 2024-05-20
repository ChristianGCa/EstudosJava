package com.acme.priority;

public class ThreadPrioritySample {

    public static void main(String[] args) {
        
        int[] executions = new int[4];
        
        Thread t0 = new Task(0, executions);
        Thread t1 = new Task(1, executions);
        Thread t2 = new Task(2, executions);
        Thread t3 = new Task(3, executions);
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
    
}
