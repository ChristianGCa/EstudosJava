package executor;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}
