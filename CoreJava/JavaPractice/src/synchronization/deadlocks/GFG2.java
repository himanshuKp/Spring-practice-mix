package synchronization.deadlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
    private ReentrantLock lock;
    private String name;

    public Worker(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        while (!lock.tryLock()){
            System.out.println(name+" waiting for lock.");
        }
        System.out.println(name + " acquired lock");
        lock.unlock();
        System.out.println(name+" released lock");
    }
}

public class GFG2 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Worker(lock, "Job1"));
        service.execute(new Worker(lock, "Job2"));
        service.shutdown();
    }
}
