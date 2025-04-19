package dsa.arrays;

/*
* Duplicate within K Distance in an Array
*   Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5]
    Output: Yes
    Explanation: 1 is present at index 0 and 3.
* */

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Problem6 {
    public static void main(String[] args) {
        int[] originalArr = {1, 2, 3, 4, 1, 2, 3, 4};
        int distance = 3;

        boolean value = checkForDuplicateValue(originalArr, distance);
        System.out.println(value);
    }

    private static boolean checkForDuplicateValue(int[] originalArr, int distance) {
        HashSet<Integer> dupSet = new LinkedHashSet<>();
        for (int i = 0; i < originalArr.length; i++) {
            if (dupSet.contains(originalArr[i])) {
                return true;
            }
            dupSet.add(originalArr[i]);
            if(i >= distance)
                dupSet.remove(originalArr[i-distance]);
        }
        return false;
    }
}
