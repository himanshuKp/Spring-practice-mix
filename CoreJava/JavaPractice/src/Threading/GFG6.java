package Threading;

class TickTock1 {
    int count;
    public void increment(){
        count++;
    }
}

public class GFG6 {
    public static void main(String[] args) throws InterruptedException {
        TickTock1 tt = new TickTock1();

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
