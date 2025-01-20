package Threading.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class Counter1 {
    AtomicInteger count = new AtomicInteger();

    public void increment(){
        System.out.println("Thread: "+Thread.currentThread().getName()+" count: "+count);
        count.incrementAndGet();
    }
}

public class GFG18 {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}
