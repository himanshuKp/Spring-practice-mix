package functionalInterface;

public class GFG1 {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("New thread created.");
        }).start();
    }
}
