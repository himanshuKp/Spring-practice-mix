package functionalInterface;

public class Sender {
    public void send(String message) {
        System.out.println("Sending: "+message);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message+" sent.");
    }
}
