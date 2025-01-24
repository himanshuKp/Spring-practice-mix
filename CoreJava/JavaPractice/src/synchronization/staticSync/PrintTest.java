package synchronization.staticSync;

public class PrintTest extends Thread{
    synchronized public static void printThread(int n){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread "+n+" is working...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.addSuppressed(e);
            }
        }
        System.out.println("----------------------------------");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e){
            e.addSuppressed(e);
        }
    }
}
