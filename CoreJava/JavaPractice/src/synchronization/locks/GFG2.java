package synchronization.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GFG2 extends Thread{
    ReentrantLock lock = new ReentrantLock();

    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();

    int counter;
    GFG2(int counter){
        this.counter = counter;
    }

    int MAX = 10;

    @Override
    public void run() {
        while (counter <= MAX){
            lock.lock();
            try {
                if (counter%2 == 1 && Thread.currentThread()
                        .getName().equals("even")) {
                    even.await();
                } else if (counter % 2 == 0 && Thread.currentThread()
                        .getName().equals("odd")) {
                    odd.await();
                } else {
                    System.out.println(Thread.currentThread().getName()
                            +" thread "+counter);
                    counter+=1;
                    if (counter%2 == 0){
                        even.signal();
                    } else {
                        odd.signal();
                    }
                }
            }
            catch (InterruptedException exception){
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        GFG2 gfg2 = new GFG2(0);
        Thread even = new Thread(gfg2, "even");
        Thread odd = new Thread(gfg2, "odd");
        even.start();
        odd.start();
    }
}
