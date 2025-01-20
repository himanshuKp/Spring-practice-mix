package Threading;

class MyThread4 extends Thread {
    public void run(){
        System.out.println("Current thread name: "+currentThread().getName());
        System.out.println("run() method called");
    }
}

public class GFG8 {
    public static void main(String[] args) {
        MyThread4 mt = new MyThread4();
        mt.start();
        mt.start(); // throws illegalthreadstateexception
    }
}
