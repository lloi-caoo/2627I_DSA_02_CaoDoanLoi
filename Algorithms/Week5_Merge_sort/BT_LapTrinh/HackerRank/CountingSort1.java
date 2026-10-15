package Week5_Merge_sort.BT_LapTrinh.HackerRank;

import java.util.*;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> count = new ArrayList<>(Collections.nCopies(100, 0));

        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i);
            count.set(index, count.get(index) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        List<Integer> result = CountingSort1.countingSort(arr);

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

