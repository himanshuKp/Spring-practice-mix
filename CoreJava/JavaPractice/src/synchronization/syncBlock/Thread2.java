package synchronization.syncBlock;

public class Thread2 extends Thread{
    PrintTest test;

    Thread2(PrintTest p){
        test = p;
    }

    @Override
    public void run() {
        test.printTest(2);
    }
}
