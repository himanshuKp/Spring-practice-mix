package Threading;

class DaemonThread2 extends Thread {
    public DaemonThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        if(currentThread().isDaemon()){
            System.out.println(currentThread().getName()+" is a daemon thread.");
        } else {
            System.out.println(currentThread().getName()+" is a user thread.");
        }
    }
}

public class GFG14 {
    public static void main(String[] args) {
        DaemonThread2 dt1 = new DaemonThread2("dt1");
        DaemonThread2 dt2 = new DaemonThread2("dt2");
        DaemonThread2 dt3 = new DaemonThread2("dt3");

        dt1.setDaemon(true);
        dt1.start();
        dt2.start();

        dt3.setDaemon(true);
        dt3.start();

    }
}
