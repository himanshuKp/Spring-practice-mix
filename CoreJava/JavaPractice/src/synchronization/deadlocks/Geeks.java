package synchronization.deadlocks;

import java.util.concurrent.locks.ReentrantLock;

public class Geeks {
    private static int c = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void increment(){
        lock.lock();

        try {
            c++;
            System.out.println(Thread.currentThread().getName()+" incremented counter to: "+c);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 4; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task, "Thread - 1");
        Thread t2 = new Thread(task,  "Thread - 2");

        t1.start();
        t2.start();
    }
}
