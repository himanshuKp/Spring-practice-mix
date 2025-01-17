package Threading;

class TickTock {
    int count;

    public void increment(){
        count++;
    }
}

public class GFG5 {
    public static void main(String[] args) throws InterruptedException {
        TickTock tt = new TickTock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    tt.increment();
                }
            }
        });

        t1.start();
        // now we are making main thread wait so that
        // thread t1 completes it job using join() method
        t1.join();
        System.out.println("Count: "+tt.count);
    }
}
