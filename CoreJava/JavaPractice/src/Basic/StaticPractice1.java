package Basic;

class Account {
    static int balance;
    static {
        balance = 500;
    }
    public static int getMinBalance(int depositAmount) {
        balance = balance+depositAmount;
        return balance;
    }
}

public class StaticPractice1 {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(Account.getMinBalance(500));
        System.out.println(Account.balance);
    }
}
