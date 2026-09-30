// HackerRank : Insertion sort Part 1

package Week4_sort.BT_Lap_Trinh.Bai3;

import java.util.Scanner;

public class Insertion_Sort_Part1 {
    public static void insertionSort(int n , int[] arr){
        int tmp = arr[n - 1];
        int j = n - 2;
        while(j >= 0 && arr[j] >= tmp){
            arr[j+1] = arr[j];
            j--;
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        arr[j + 1] = tmp;
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(n, arr);
    }
}
