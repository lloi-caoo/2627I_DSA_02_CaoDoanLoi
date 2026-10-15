package Week6_QuickSort.BaiTap_LapTrinh;

import java.io.*;
import java.util.*;

public class QuickSortInPlace {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int partition(int[] arr, int left , int right){
        int pivot = arr[right];
        int i = left;

        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp =  arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        printArray(arr);
        return i;
    }

    public static void quicksort(int[] arr, int i , int j){
        if(i < j){
            int pivotIndex = partition(arr, i , j);
            quicksort(arr, i, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, j);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        quicksort(arr, 0, n-1);
        sc.close();
    }
}

