package PatternMatch;

public class PatternMatch1 {
    public static void main(String[] args) {
        Object obj = new String("hello");

//        use pattern matching in switch expression
        String result = switch (obj) {
            case Integer i -> "It's an integer: "+i;
            case String s -> s.toUpperCase();
            case null -> "Object is null";
            default -> "Unknown type";
        };

        System.out.println(result);
    }
}
