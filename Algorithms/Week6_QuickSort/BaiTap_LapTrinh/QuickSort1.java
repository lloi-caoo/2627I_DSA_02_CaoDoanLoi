package Week6_QuickSort.BaiTap_LapTrinh;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickSort1 {

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && arr.get(i) <= pivot) {
                i++;
            }

            while (i <= j && arr.get(j) > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static List<Integer> quickSort(
            List<Integer> arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            arr.add(sc.nextInt());
        }

        quickSort(arr, 0, arr.size() - 1);

        System.out.println(arr);

        sc.close();
    }
}

