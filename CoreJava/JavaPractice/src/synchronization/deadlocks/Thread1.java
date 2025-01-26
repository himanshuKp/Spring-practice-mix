package synchronization.deadlocks;

public class Thread1 extends Thread{
    private final Shared shared1;
    private final Shared shared2;

    public Thread1(Shared shared1, Shared shared2) {
        this.shared1 = shared1;
        this.shared2 = shared2;
    }

    @Override
    public void run() {
        shared1.test1(shared2);
    }
}
