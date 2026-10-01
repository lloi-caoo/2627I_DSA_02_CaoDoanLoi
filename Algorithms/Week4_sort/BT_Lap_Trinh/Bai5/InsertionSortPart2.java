// Hacker Rank : insertionSortPart2

package Week4_sort.BT_Lap_Trinh.Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSortPart2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        for(int i = 1; i < n; i++){
            int tmp = arr.get(i);
            int j = i - 1;
            while(j >= 0 && arr.get(j) >= tmp){
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, tmp);
            for(int k = 0; k < n; k++){
                System.out.print(arr.get(k) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        insertionSort2(n, arr);
        sc.close();
    }

}
