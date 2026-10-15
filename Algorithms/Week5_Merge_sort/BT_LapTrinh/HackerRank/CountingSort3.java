package Week5_Merge_sort.BT_LapTrinh.HackerRank;

import java.util.*;

public class CountingSort3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[100];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            String s = sc.next();
            count[x] ++;
        }
        for(int i = 1; i < 100; i++){
            count[i] += count[i - 1];
        }
        for(int i = 0; i < 100; i++){
            System.out.print(count[i] + " ");
        }
        sc.close();
    }
}
