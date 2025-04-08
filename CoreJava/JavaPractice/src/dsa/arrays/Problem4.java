package dsa.arrays;

/*
* print unique elements in the array
* */

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Problem4 {
    public static void main(String[] args) {
        int[] originalArray = {12, 10, 9, 45, 2, 10, 10, 45};

        printUniqueElements(originalArray);
    }

    private static void printUniqueElements(int[] originalArray) {
//        create hashset object
        HashSet<Integer> set = new LinkedHashSet<>();
        for (int element : originalArray) {
            set.add(element);
        }

        System.out.println(set);;
    }
}
