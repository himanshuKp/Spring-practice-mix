package dsa.arrays;

/*
*   Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
    Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
    Explanation: There are three 0s that are moved to the end.
* */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem5 {
    public static void main(String[] args) {
        int[] originalArray = {3, 5, 0, 0, 4};

        moveAllZeroesToEnd(originalArray);
    }

    private static void moveAllZeroesToEnd(int[] arr) {
        int nonZeroIndex = 0;

        for (int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }

        //put 0 to remaining index of array
        for (int i=nonZeroIndex; i<arr.length; i++){
            arr[i] = 0;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
