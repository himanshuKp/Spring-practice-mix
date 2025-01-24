package synchronization.nonsync;

public class Thread2 extends Thread{
    PrintTest test;

    Thread2(PrintTest p) {
        test = p;
    }

    @Override
    public void run() {
        test.printThread(2);
    }
}
