package Threading;

public class GFG12 extends Thread {
    public static void main(String[] args) {
//        getting reference to main thread
        Thread thread = Thread.currentThread();

//        getting name of main thread
        System.out.println("Current thread: "+thread.getName());

//        changing the name of main thread
        thread.setName("Geeks");
        System.out.println("After name change: "+thread.getName());

//        getting priority of main thread
        System.out.println("Main thread priority: "+thread.getPriority());

//        setting priority of main thread to MAX(10)
        thread.setPriority(MAX_PRIORITY);

//        print and display the main thread priority
        System.out.println("Main thread new priority: "+thread.getPriority());

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }

//        main thread creating a child thread
        Thread ct = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Child thread");
                }
            }
        };

        System.out.println("Child thread priority: "+ct.getPriority());

//        setting priority of main thread to MIN
        ct.setPriority(MIN_PRIORITY);

        System.out.println("Child thread new priority: "+ct.getPriority());

        ct.start();
    }
}

class ChildThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread ---");
        }
    }
}
