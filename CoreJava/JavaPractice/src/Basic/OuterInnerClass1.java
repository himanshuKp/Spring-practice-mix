package Basic;

 class OuterClass1 {
    static int outer_x=100;

    static void test(){
        Inner.display();
    }

    static class Inner {
        int y = 10;
        static void display(){
            System.out.println("Display: outer_x: "+outer_x);
        }
    }
}

public class OuterInnerClass1 {
    public static void main(String[] args) {
        OuterClass1.test();
    }
}
