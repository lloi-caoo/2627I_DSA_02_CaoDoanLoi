package Week4_sort;

import java.util.Scanner;

public class W4_25020249 {
    public static void insertionSort(int[] a , int n){
        for(int i = 1; i < n; i++){
            int j =  i - 1;
            int temp = a[i];
            while(j >= 1 && a[j] > temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        insertionSort(a,n);

        int i = n - 1;
        while( i >= 0 && a[i] >= n - i){
            i = i - 1;
        }
        System.out.println(n - i - 1);
    }
}
