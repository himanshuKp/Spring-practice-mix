package synchronization.deadlocks;

public class GFG1 {
    public static void main(String[] args) {
        Shared shared1 = new Shared();
        Shared shared2 = new Shared();

        Thread1 thread1 = new Thread1(shared1, shared2);
        thread1.setName("Thread1");
        thread1.start();

        Thread2 thread2 = new Thread2(shared1, shared2);
        thread2.setName("Thread2");
        thread2.start();
        Util.sleep(2000);
    }
}
