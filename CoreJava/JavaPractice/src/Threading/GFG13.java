package Threading;

class DaemonThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Running the daemon thread");
    }
}

public class GFG13 {
    public static void main(String[] args) {
        DaemonThread1 daemonThread1 = new DaemonThread1();
        daemonThread1.setDaemon(true);

        daemonThread1.start();
    }
}
