package com.acme.async;

import java.util.ArrayList;
import java.util.List;
import java.lang.Runnable;
import java.util.Collections;

public class AsyncApp {

    private static final int QUANTIDADE = 100;
    //private static final List<String> list = new ArrayList();
    private static final List<String> list = Collections.synchronizedList(new ArrayList<>());
    
    public static void main(String[] args) {

        // Classe anônima public class AsyncApp$1 implements Runnable {}
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    // Faz só uma thread por vez executar o list.add()
                    //synchronized (list) {
                        list.add("A");
                    //}

                }
            }

        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    //synchronized (list) {
                        list.add("B");
                    //}
                }
            }

        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    //synchronized (list) {
                        list.add("C");
                    //}
                }
            }

        });
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            
        }catch(InterruptedException ex){}
        for (String s : list) {
            System.out.print(s);
        }
    }

}
