package synchronization.syncBlock;

public class PrintTest extends Thread{
    public void printTest(int n) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread "+n+" is working...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("-------------------------------------");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
