package synchronization.nonsync;

public class PrintTest extends Thread{
    synchronized public void printThread(int n) {
        for (int i = 1; i < 11; i++) {
            System.out.println("Thread "+n+" is working...");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("----------------------------------");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
