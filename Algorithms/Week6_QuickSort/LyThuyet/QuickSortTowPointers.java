package Week6_QuickSort.LyThuyet;

import java.util.Arrays;

public class QuickSortTowPointers {

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];  // pivot = arr[high]
        int i = low + 1;       // i = low
        int j = high;          // j = high - 1

        while(i <= j){
            while(i <= j && arr[i] <= pivot){
                i++;
            }
            while(i <= j && arr[j] > pivot){
                j--;
            }
            if(i < j){
                swap(arr, i ,j);
                i++;
                j--;
            }
        }
        swap(arr, j, low);  // swap(arr,i ,high)
        return j;
    }


    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);

            // de quy nua trai
            quickSort(arr, low , pivotIndex - 1);
            // de quy nua phai
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    // ham swap
    private  static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 6 , 3, 7};
        System.out.println("Unsorted Array : " + Arrays.toString(arr));

        quickSort(arr, 0 , arr.length - 1);
        System.out.println("Array sorted in Ascending order : " + Arrays.toString(arr));
    }
}
