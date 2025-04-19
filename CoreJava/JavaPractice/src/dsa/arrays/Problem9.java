package dsa.arrays;

/*
* Given an integer  array arr, return all the unique pairs [arr[i],
* arr[j]] such that i != j and arr[i] + arr[j] == 0.
* */

import java.awt.*;
import java.util.*;
import java.util.List;

public class Problem9 {
    public static void main(String[] args) {
        int[] arr1 = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        List<List<Integer>> result1 = findUniqueZeroSumPairs(arr1);
        System.out.println(result1);
    }

    private static List<List<Integer>> findUniqueZeroSumPairs(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return  new ArrayList<>();
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePair = new HashSet<>();

         for (int num : arr) {
             int compliment = -num;
             if (seen.contains(compliment)){
                 int minValue = Math.min(num, compliment);
                 int maxValue = Math.max(num, compliment);
                 String pairString = minValue + "," + maxValue;
                 if(uniquePair.add(pairString)){
                    result.add(Arrays.asList(minValue, maxValue));
                 }
             }
             seen.add(num);
         }

         return result;
    }
}
