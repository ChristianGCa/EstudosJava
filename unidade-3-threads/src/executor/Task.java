package executor;

import java.util.Random;

public class Task implements Runnable {
    
    private int id;
    
    public Task (int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        System.out.printf("Tarefa #%d sendo executada \n",id);
        
        Random r = new Random();
        int time = r.nextInt(500, 1500);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {}
    }
    
    
}
