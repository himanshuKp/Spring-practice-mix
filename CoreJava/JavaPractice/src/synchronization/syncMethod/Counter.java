package synchronization.syncMethod;

import java.util.concurrent.TimeUnit;

public class Counter extends Thread{
    private int count;

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
