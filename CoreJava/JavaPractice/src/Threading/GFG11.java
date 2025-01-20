package Threading;

class MyThread6 implements Runnable {
    public void run(){
//        moving thread2 to timed waiting  state
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("state of thread1 while it called"+
                " join() method on thread2 - "+ MyThread7.thread1.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread7 implements Runnable {
    public static Thread thread1;
    public static MyThread7 myThread7;

    @Override
    public void run() {
        MyThread6 myThread6 = new MyThread6();
        Thread thread2 = new Thread(myThread6);

//        thread2 created and is currently
//        in the new state
        System.out.println("State of thread2 after creating it - "+thread2.getState());

        thread2.start();

//        thread2 moved to runnable state
        System.out.println("state of thread2 after calling start() method" +
                " on it "+thread2.getState());

        try {
//            moving thread2 to timed waiting state
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("State of thread2 after calling sleep()" +
                " method on it - "+thread2.getState());

        try {
//            waiting for thread2 to die
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("state of thread2 when it has finished " +
                "it's execution - "+thread2.getState());
    }

    public static void main(String[] args) {
        myThread7 = new MyThread7();
        thread1 = new Thread(myThread7);

//        thread1 is created and in the new state
        System.out.println("state of thread1 after creating it - " +
                thread1.getState());

        thread1.start();

//        thread1 moved to runnable state
        System.out.println("state of thread1 after calling start() " +
                "method on it - "+thread1.getState());
    }
}
