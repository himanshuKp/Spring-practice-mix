package Basic;

public class BytePractice {
    public static void main(String... args){
//        byte a = 40;
//        byte b = 50;
//        byte c = 100;
//
//        int d = a * b / c;
//        System.out.println("output: "+d);
        notWorkingByte();
    }

    private static void notWorkingByte() {
        byte a = 40;
        byte b = 50;
//        byte c = a * b; // compile error for cast
        byte c = (byte) (a * b);
        System.out.println("output: "+c);   // gives negative value as output
    }
}
