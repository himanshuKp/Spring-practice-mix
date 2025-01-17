package Threading;

class CheckingMyDaemonThread extends Thread {
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("I am daemon thread and I am working");
        } else {
            System.out.println(
                    "I am user thread and I am working");
        }
    }
}

public class GFG3 {
    public static void main(String[] args) {
        CheckingMyDaemonThread t1 = new CheckingMyDaemonThread();
        CheckingMyDaemonThread t2 = new CheckingMyDaemonThread();
        CheckingMyDaemonThread t3 = new CheckingMyDaemonThread();

        t2.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}
