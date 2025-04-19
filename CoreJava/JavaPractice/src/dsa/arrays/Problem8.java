package dsa.arrays;

/*
* binary search
* */

public class Problem8 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2};
        int k = 1;
        int result = binarySearchImpl(arr, k);
        System.out.println("Result: "+result);
    }

    private static int binarySearchImpl(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k){
                result = mid;
                high = mid - k;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
