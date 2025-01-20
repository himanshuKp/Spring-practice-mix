package Threading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if(i==0){
                    Date date = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization time for "+
                            "task name = "+name+ " = "+ft.format(date));
                } else {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class GFG19 {
    static final int MAX_T = 3;

    public static void main(String[] args) {
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");

        ExecutorService es = Executors.newFixedThreadPool(MAX_T);

        es.execute(r1);
        es.execute(r2);
        es.execute(r3);
        es.execute(r4);
        es.execute(r5);

        es.shutdown();
    }
}
