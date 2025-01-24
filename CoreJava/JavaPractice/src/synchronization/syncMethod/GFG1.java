package synchronization.syncMethod;

public class GFG1 {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.start();
        c2.start();
        c1.join();
        c2.join();

        System.out.println("Count1: "+c1.getCount());
        System.out.println("Count2: "+c2.getCount());
    }
}
