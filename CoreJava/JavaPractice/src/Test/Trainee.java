package Test;

abstract class Employee {
   private void display() {
          System.out.print(" Employee ");
   }
}

public class Trainee extends Employee {
    protected void display() { // line 5
        System.out.print(" Trainee ");
    }

    public static void main(String[] args) {
        Employee emp = new Trainee();
//          emp.display(); // line 10
    }
}