package synchronization.volatileKeyword;

public class Counter {
    private volatile int count;

    public void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
