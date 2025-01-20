package Threading;

class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }
}

class MyThread5 extends Thread {

    private Counter counter;

    public MyThread5(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {

            this.counter.setCount(i);
            System.out.println(Thread.currentThread().getName()
                    + " - Count : " + this.counter.getCount());

//            try {
//                // Sleep for 500 milliseconds
//                Thread.sleep(500);
//            }
//            catch (InterruptedException e) {
//                System.out.println("Thread interrupted");
//            }
        }
    }
}

public class GFG9 {
    public static void main(String[] args) {
        Counter c1 = new Counter();

        MyThread5 t1 = new MyThread5(c1);
        MyThread5 t2 = new MyThread5(c1);

        t1.start();
        t2.start();
    }
}
