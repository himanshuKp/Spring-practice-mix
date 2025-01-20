package Threading.Concurrency;

class Counter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run(){
        System.out.println("Running the thread");
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class GFG1 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final count: "+counter.getCount());
    }
}
