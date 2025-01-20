package functionalInterface;

@FunctionalInterface
interface Functional {
    int operation(int a, int b);
}

public class GFG4 {
    public static void main(String[] args) {
        Functional add = (a, b) -> a + b;
        Functional multiply = (a, b) -> a * b;

        System.out.println(add.operation(2,3));
        System.out.println(multiply.operation(2,3));
    }
}
