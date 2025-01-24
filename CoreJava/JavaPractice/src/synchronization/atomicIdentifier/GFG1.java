package synchronization.atomicIdentifier;

public class GFG1 {
    public static void main(String[] args) {
        CounterThread ct1 = new CounterThread();
        CounterThread ct2 = new CounterThread();

        ct1.start();
        ct2.start();
        try {
            ct1.join();
            ct2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: "+(ct1.getCount() + ct2.getCount()));
    }
}
