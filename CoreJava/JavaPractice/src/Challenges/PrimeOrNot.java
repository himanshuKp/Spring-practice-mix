package Challenges;

public class PrimeOrNot {
    public static void main(String[] args) {
//        check if the number is prime or not
        boolean isPrime = checkPrime(14);
        System.out.println("is it prime: "+isPrime);
    }

    private static boolean checkPrime(int value) {
//        base condition: no less than or equal to 1 are not prime
        if(value <= 1){
            return false;
        }

//        optimization: check for divisibility by 2
        if(value % 2 == 0){
            return value == 2;
        }

//        check for divisibility by odd numbers up to the square root of the number
        for(int i = 3;i*i <= value;i+=2){
            if(value % i == 0){
                return false;   // if divisible, it's not prime
            }
        }

//        if no divisor found, it's prime
        return true;
    }
}
