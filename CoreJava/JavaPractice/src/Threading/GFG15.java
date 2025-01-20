package Threading;

class DaemonThread3 extends Thread {
    public DaemonThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread name: "+currentThread().getName());
        System.out.println("Check if its daemon thread: "+currentThread().isDaemon());
    }
}

public class GFG15 {
    public static void main(String[] args) {
        DaemonThread3 dt1 = new DaemonThread3("dt1");
        DaemonThread3 dt2 = new DaemonThread3("dt2");

        try {
            dt1.start();

//            exception as the thread has already started
            dt1.setDaemon(true);
            dt2.start();
        } catch (IllegalThreadStateException e){
            System.out.println("Illegal thread state exception thrown");
        }
    }
}
