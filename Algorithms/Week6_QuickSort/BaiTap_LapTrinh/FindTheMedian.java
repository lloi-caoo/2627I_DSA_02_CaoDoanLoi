package Week6_QuickSort.BaiTap_LapTrinh;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    private  static void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static int paritition(List<Integer> arr , int l , int r){
        int pivot = arr.get(l);
        int i = l + 1;
        int j = r;
        while(i <= j){
            while(i <= j && arr.get(i) <= pivot){
                i++;
            }
            while(i <= j && arr.get(j) > pivot){
                j--;
            }
            if(i < j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, j, l);
        return j;

    }
    public static int quickSort(List<Integer> arr ,int l , int r){
        if( l == r){
            return arr.get(l);
        }
        int index = paritition(arr, l, r);
        if(index == arr.size()/ 2) return arr.get(index);
        if(index < arr.size()/2){
            return quickSort(arr, index + 1, r);
        }
        else{
            return quickSort(arr, l, index - 1);
        }
    }
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        return quickSort(arr, 0, arr.size() - 1);
    }

}

public class FindTheMedian {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(Result.findMedian(arr));
    }
}

