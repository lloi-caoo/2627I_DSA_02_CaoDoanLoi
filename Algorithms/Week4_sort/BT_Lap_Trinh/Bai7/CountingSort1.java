package Week4_sort.BT_Lap_Trinh.Bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingSort1 {
    public static List<Integer> counting(List<Integer> arr){
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tmp.add(0);
        }
        for(int i = 0; i < arr.size(); i++){
            tmp.set(arr.get(i) , tmp.get(arr.get(i)) + 1);
        }
        return tmp;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0){
            int x = sc.nextInt();
            arr.add(x);
            n--;
        }
        counting(arr);
    }
}
