package Basic;

public class StringPractice2 {
    public static void main(String[] args) {
        String stringObj1 = "First String";
        String stringObj2 = "Second String";
        String stringObj3 = stringObj1;

        System.out.println("Length of stringObj1: " + stringObj1.length());
        System.out.println("Char at index 3 in stringObj2: " + stringObj1.charAt(3));

        if (stringObj1.equals(stringObj2)) {
            System.out.println("strobj1 == strobj2");
        } else {
            System.out.println("strobj1 != strobj2");
        }
    }
}
