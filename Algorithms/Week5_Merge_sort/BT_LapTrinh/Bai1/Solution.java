package Week5_Merge_sort.BT_LapTrinh.Bai1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Result {

    public static int introTutorial(int V, List<Integer> arr) {
        int l = 0;
        int r = arr.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr.get(m) == V) {
                return m;
            } else if (arr.get(m) < V) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(Result.introTutorial(V, arr));
    }
}