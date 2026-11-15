package Week10_DivideCompare_Avl_Backtracking;

import java.util.Scanner;

public class W10_tailop_25020249 {
    static class Result{
        int min;
        int max;
        Result(int min , int max){
            this.min = min;
            this.max = max;
        }
    }

    static Result findMaxMin(int[] arr, int l , int r){
        // con 1 ptu
        if(l == r){
            return new Result(arr[l], arr[r]);
        }
        // con 2 ptu
        if(r == l + 1){
            if(arr[l] > arr[r]){
                return new Result(arr[r], arr[l]);
            }
            else{
                return new Result(arr[l], arr[r]);
            }
        }

        int mid = l + (r - l)/2;
        Result left = findMaxMin(arr, l , mid);
        Result right = findMaxMin(arr, mid + 1, r);

        int max = Math.max(left.max, right.max);
        int min = Math.min(left.min, right.min);

        return new Result(min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Result res = findMaxMin(arr, 0, n - 1);

        System.out.println("Max = " + res.max);
        System.out.println("Min = " + res.min);

        sc.close();

    }
}
