package functionalInterface;

public class GFG12 {
    public static void main(String[] args) {
        Sender sender = new Sender();

        ThreadedSend ts1 = new ThreadedSend("Hi", sender);
        ThreadedSend ts2 = new ThreadedSend("Bye", sender);

        ts1.start();
        ts2.start();

        try {
            ts1.join();
            ts2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
