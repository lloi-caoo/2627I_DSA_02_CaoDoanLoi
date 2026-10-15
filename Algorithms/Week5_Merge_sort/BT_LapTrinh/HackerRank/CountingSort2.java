package Week5_Merge_sort.BT_LapTrinh.HackerRank;

import java.util.*;

public class CountingSort2 {
    public static List<Integer> countingSort(List<Integer> arr) {
        int size = arr.size();

        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            count.add(0);
        }

        // tan suat tung ptu
        for (int i = 0; i < size; i++) {
            int index = arr.get(i);
            count.set(index, count.get(index) + 1);
        }

        // tan suat tich luy
        for (int i = 1; i < 100; i++) {
            count.set(i, count.get(i - 1) + count.get(i));
        }

        int[] output = new int[size];
        // sap xep vao output ( xep truc tiep vao arr se lam mat gia tri)
        for (int i = size - 1; i >= 0; i--) {
            int index = arr.get(i);
            output[count.get(index) - 1] = index;
            count.set(index, count.get(index) - 1);
        }

        // dua vao arr
        for (int i = 0; i < size; i++) {
            arr.set(i, output[i]);
        }

        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        List<Integer> result = CountingSort2.countingSort(arr);

        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));
        }

        System.out.println();
        sc.close();
    }
}

