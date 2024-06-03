package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Java Thread pool rerpesenta um grupo de threads que estão aguardando tarefas e são reutilizadas várias vezes
public class ExecutorApp {

    private static final int NUMBER_OF_THREADS_IN_POOL = 5;
    
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS_IN_POOL, new MyThreadFactory());
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Task t = new Task(i);
            executor.submit(t);
        }
        
        executor.shutdown();
        
        while (!executor.isTerminated()) {
            System.out.println("Aguardando finalização das tarefas pendentes...");
            try {
                // Thread main durma por 1 segundo
                Thread.sleep(1000);
            }catch(InterruptedException ex) {}
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Todas as tarefas foram executadas!");
        System.out.println("Tempo total: " + (end-start) + " ms");
        
    }
    
}
