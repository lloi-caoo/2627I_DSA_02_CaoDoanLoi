package Week5_Merge_sort.Cac_loai_Sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class BucketSort {

    public static void bucketSort(double[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        double min = arr[0];
        double max = arr[0];

        for (double x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        if (min == max) return;

        // Tao n bucket
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Phan phoi phan tu vao bucket
        for (double x : arr) {
            int index = (int) ((x - min) / (max - min) * n);

            if (index >= n) index = n - 1;

            buckets.get(index).add(x);
        }

        // Sap xep tung bucket
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Ghep cac bucket vao mang ban dau
        int k = 0;

        for (ArrayList<Double> bucket : buckets) {
            for (double x : bucket) {
                arr[k++] = x;
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {2.75, -1.2, 3.14, 0.5, 2.1, -0.8};

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

