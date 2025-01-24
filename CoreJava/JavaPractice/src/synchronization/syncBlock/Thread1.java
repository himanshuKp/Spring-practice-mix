package synchronization.syncBlock;

public class Thread1 extends Thread{
    PrintTest test;

    Thread1(PrintTest p) {
        test = p;
    }

    @Override
    public void run() {
        test.printTest(1);
    }
}
