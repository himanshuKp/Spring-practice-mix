package functionalInterface;

public class GFG10 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                account.deposit(200);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                account.withdraw(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: "+account.getBalance());
    }
}
