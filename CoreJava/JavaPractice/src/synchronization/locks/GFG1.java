package synchronization.locks;

public class GFG1 {
    public static void main(String[] args) {
        TestResource resource = new TestResource();

        for (int i = 0; i < 2; i++) {
            new Thread(new DisplayJob(resource), "Thread "+(i+1)).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(new ReadJob(resource), "Thread "+(i+1)).start();
        }
    }
}
