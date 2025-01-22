package functionalInterface;

public class Counter {
    int count = 0;

    public synchronized void setCount(){
        count++;
    }

    public synchronized int getCount(){
        return count;
    }
}
