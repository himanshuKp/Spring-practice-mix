package Test;

public class Tester {
       public static void main(String[] args) {
             Base obj = new Derived();
             obj.method(25);
       }
}

class Base {
       public static void method(int a) {
           String firstString = "String";
           StringBuilder secondString = new StringBuilder("String");
//           System.out.println(firstString==secondString);
           System.out.println(firstString.contains(secondString));;
           System.out.println(secondString.equals(firstString));
           System.out.println(firstString.equals(secondString));
           System.out.println("Base Method");
       }
}

class Derived extends Base {
       public static void method(int a) {
             System.out.println("Derived Method");
       }
}