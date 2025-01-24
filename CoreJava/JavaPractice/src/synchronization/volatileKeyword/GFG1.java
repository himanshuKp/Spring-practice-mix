package synchronization.volatileKeyword;

public class GFG1 {
    public static void main(String[] args) {
        Counter c1 = new Counter();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Count: "+c1.getCount());
    }
}
