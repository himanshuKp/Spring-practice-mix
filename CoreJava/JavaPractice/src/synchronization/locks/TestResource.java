package synchronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DisplayJob implements Runnable {
    private final TestResource resource;

    DisplayJob(TestResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.displayRecord(new Object());
    }
}

class ReadJob implements Runnable {
    private final TestResource resource;

    ReadJob(TestResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.readRecord(new Object());
    }
}

public class TestResource {
    private final Lock displayLock = new ReentrantLock();
    private final Lock readLock = new ReentrantLock();

    public void displayRecord(Object document){
        displayLock.lock();

        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+": Displaying...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            displayLock.unlock();
        }
    }

    public void readRecord(Object document) {
        readLock.lock();

        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+": Reading...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
