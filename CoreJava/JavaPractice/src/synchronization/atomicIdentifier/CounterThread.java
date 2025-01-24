package synchronization.atomicIdentifier;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread extends Thread{
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(i*50);
                count.incrementAndGet();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count.get();
    }
}
