package Basic;

public class MethodOverload {
    static void vaTest(int... v){
        System.out.println(v);
    }

    static void vaTest(int n, int... v){
        System.out.println(n +" : "+ v);
    }

    public static void main(String[] args) {
        ;
    }
}
