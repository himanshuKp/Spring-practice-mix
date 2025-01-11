package Sorting;

public class MergeSort1 {
//    driver method
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int arrSize = arr.length - 1;
        MergeSort1 ob = new MergeSort1();
        ob.sort(arr, 0, arrSize);

        System.out.println("Sorted array");
        for (int j : arr) System.out.print(j + " ");
    }

    private void sort(int[] arr, int startIndex, int lastIndex) {
        if(startIndex < lastIndex){
//            find the middle point
            int middleIndex = (startIndex + lastIndex) / 2;

//            sort first and second halves
            sort(arr, startIndex, middleIndex);
            sort(arr, middleIndex+1, lastIndex);

//            merge the sorted halves
            merge(arr, startIndex, middleIndex, lastIndex, new int[arr.length]);
        }
    }

//    merge two sub arrays of arr[]
//    first sub array is arr[startIndex....middleIndex]
//    second sub array is arr[middleIndex+1.....lastIndex]
    private void merge(int[] arr, int startIndex, int middleIndex, int lastIndex, int[] temp) {
//        copy the first half to the temp array
        System.arraycopy(arr, startIndex, temp, startIndex, middleIndex - startIndex + 1);

//        initial indexes of first and second subarrays
        int i = startIndex, j = middleIndex + 1, k = lastIndex;

        while (i <= middleIndex && j <= lastIndex){
            if(temp[i]<=arr[j]){
                arr[k++] = temp[i++];
            } else {
                arr[k++] = arr[j++];
            }
        }

//        copy remaining elements of the first half from temp to arr
        System.arraycopy(temp, i, arr, k, middleIndex - i + 1);
    }

}
