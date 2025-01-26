package synchronization.deadlocks;

public class Shared {
    synchronized void test1 (Shared shared) {
        System.out.println(Thread.currentThread().getName()+" enters test1 of "+ this);
        Util.sleep(1000);

        shared.test2();
        System.out.println(Thread.currentThread().getName()+" exists test1 of "+this);
    }

    synchronized void test2() {
        System.out.println(Thread.currentThread().getName()+ " enters test2 of "+this);
        Util.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" exits test2 of " +this);
    }
}
