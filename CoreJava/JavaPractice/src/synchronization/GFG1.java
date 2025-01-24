package synchronization;

class Test {
    synchronized void test_func(int n){
        for (int i = 0; i < 4; i++) {
            System.out.println(n + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class GFG1 {
    public static void main(String[] args) {
        final Test o = new Test();

        Thread a = new Thread() {
            public void run(){
                o.test_func(5);
            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                o.test_func(10);
            }
        };

        a.start();
        b.start();
    }
}
