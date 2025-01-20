package functionalInterface;

@FunctionalInterface
interface ZeroParameter {
    void display();
}

public class GFG3 {
    public static void main(String[] args) {
        ZeroParameter zeroParameter = () ->
                System.out.println(
                        "Zero parameter lambda experession"
                );

        zeroParameter.display();
    }
}
