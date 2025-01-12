package Basic;

class Loan {
    int tenure = 0;
    double principal;
    float interestRate;
    String accountNumber;
    final double calculateEmi(){
        return 2000;
    }
}

public class ParentChildPractice1 extends Loan {
//    cannot be overridden as calculateEmi is final
//    double calculateEmi(){
//
//    }
    public static void main(String[] args) {

    }
}
