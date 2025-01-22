package functionalInterface;

public class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount){
        balance += amount;
        System.out.println("Deposited: "+amount+", Balance: "+balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount){
            balance -= amount;
            System.out.println("Withdraw: "+amount+", Balance: "+balance);
        } else {
            System.out.println("Insufficient balance to withdraw: "+amount);
        }
    }

    public int getBalance(){
        return balance;
    }
}
