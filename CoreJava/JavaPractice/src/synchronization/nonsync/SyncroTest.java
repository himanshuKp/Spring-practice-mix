package synchronization.nonsync;

public class SyncroTest {
    public static void main(String[] args) {
        PrintTest p = new PrintTest();
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);

        t1.start();
        t2.start();
    }
}
