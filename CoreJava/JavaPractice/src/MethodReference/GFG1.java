package MethodReference;

import java.util.Arrays;

public class GFG1 {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args){
        String[] s = {"Alice", "Bob", "Charlie"};
        Arrays.stream(s).forEach(GFG1::print);
    }
}
