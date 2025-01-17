package Threading;

class MyThread3 extends Thread {
    int count = 0;
    void increment(){
        count++;
    }
    public void run(){
        increment();
        System.out.println("Count: "+count);
    }
}

public class GFG4 {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        t1.start();
    }
}
