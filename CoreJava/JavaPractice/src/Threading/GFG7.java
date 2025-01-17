package Threading;

class TickTock2 {
    int count;

    public synchronized void increment(){
        count++;
    }
}

public class GFG7 {
    public static void main(String[] args) throws InterruptedException {
        TickTock2 tt = new TickTock2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    tt.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    tt.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: "+tt.count);
    }
}
