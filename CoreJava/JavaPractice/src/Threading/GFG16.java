package Threading;

class A {
    synchronized void sum (int n){
        Thread t1 = Thread.currentThread();
        for (int i = 0; i <= 5; i++) {
            System.out.println(t1.getName() + " :  " + (n + i));
        }
    }
}

class B extends Thread {
    A a = new A();

    @Override
    public void run() {
        a.sum(10);
    }
}

public class GFG16 {
    public static void main(String[] args) {
        B b = new B();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}
