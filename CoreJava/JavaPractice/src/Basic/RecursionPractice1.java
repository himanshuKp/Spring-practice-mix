package Basic;

class Factorial {
    int fact(int n) {
        int result;

        if(n==1)
            return 1;
        result = fact(n -1) * n;
        return result;
    }
}

public class RecursionPractice1 {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("Factorial of 3 is: "+factorial.fact(3));
        System.out.println("Factorial of 6 is: "+factorial.fact(6));
        System.out.println("Factorial of 9 is: "+factorial.fact(9));
    }
}
