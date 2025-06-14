package dsa.arrays;

/*
* Given an integer  array arr, return all the unique pairs [arr[i],
* arr[j]] such that i != j and arr[i] + arr[j] == 0.
* */

import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        int[] arr1 = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        ArrayList<ArrayList<Integer>> result1 = findUniqueZeroSumPairs(arr1);
        System.out.println(result1);
    }

    private static ArrayList<ArrayList<Integer>> findUniqueZeroSumPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return result;
        }

        Arrays.sort(arr); // Sort the array to easily find complements
        Set<String> uniquePairs = new HashSet<>(); // Use a set to store unique pairs as strings

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                // Found a zero-sum pair
                String pairString = arr[left] < arr[right] ? arr[left] + "," + arr[right] : arr[right] + "," + arr[left]; //create string representation of the pair
                if (uniquePairs.add(pairString)) { // Add the string representation to the set
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(arr[left]);
                    pair.add(arr[right]);
                    result.add(pair);
                }
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
