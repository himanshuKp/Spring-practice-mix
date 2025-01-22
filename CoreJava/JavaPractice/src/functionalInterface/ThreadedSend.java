package functionalInterface;

public class ThreadedSend extends Thread{
    private String message;
    Sender sender;

    ThreadedSend(String message, Sender sender){
        this.message = message;
        this.sender = sender;
    }

    public void run() {
        synchronized (sender) {
            sender.send(message);
        }
    }
}
