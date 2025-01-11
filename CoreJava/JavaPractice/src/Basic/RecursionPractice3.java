package Basic;

public class RecursionPractice3 {
//    function to return fibonacci value
    static int Fib(int N){
        if(N==0 || N==1)
            return N;
        return Fib(N-1) + Fib(N-2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci of "+3+" is: "+Fib(3));
        System.out.println("Fibonacci of "+30+" is: "+Fib(30));
    }
}
