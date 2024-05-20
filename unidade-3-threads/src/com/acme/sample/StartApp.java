package com.acme.sample;

public class StartApp {

    public static void main(String[] args) {
        Thread obj1 = new MyObject();
        obj1.start();
        
        Thread obj2 = new MyThread();
        obj2.start();
    }
    
}
