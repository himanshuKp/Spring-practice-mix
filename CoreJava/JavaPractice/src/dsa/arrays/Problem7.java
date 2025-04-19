package dsa.arrays;/*
* find equilibrium index in the array
* */

public class Problem7 {
    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int equiIndex = findEquilibriumIndex(arr);
        System.out.println("Equilibrium index: "+equiIndex);
    }

    private static int findEquilibriumIndex(int[] arr) {
        int equilibriumIndex = -1;
        int leftSum = 0;
        int totalSum =  0;
        int n = arr.length;

        if (n == 0){
            return equilibriumIndex;
        }

        if (n == 1){
            return 0;
        }

        for (int num : arr){
            totalSum += num;
        }

        for (int i = 0; i<arr.length; i++){
            if (leftSum == totalSum - leftSum - arr[i]) {
                equilibriumIndex = i;
                break;
            }
            leftSum += arr[i];
        }

        return equilibriumIndex;
    }
}
