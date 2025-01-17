package Threading;

class MyThread extends Thread {
    public void run(){
        System.out.println("Running Thread: "+currentThread().getName());
        System.out.println("Running Thread Priority: "+currentThread().getPriority());
    }
}

public class GFG2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.run();
        t2.run();
    }
}
