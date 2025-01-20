package Threading;

import java.io.FileNotFoundException;

public class GFG10 {
    private class RunnableImple implements Runnable {
        public void run(){
            System.out.println(Thread.currentThread().getName()+", executing run() method.");

//            checked exception can't be thrown, Runnable must
//            handle checked exception ifself
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e){
                System.out.println("Must catch here");
                e.printStackTrace();
            }

            int r = 1/0;
        }
    }
    public static void main(String[] args) {
        System.out.println("Main thread is: "+Thread.currentThread().getName());

        Thread t1 = new Thread(new GFG10().new RunnableImple());
        t1.start();
    }
}
