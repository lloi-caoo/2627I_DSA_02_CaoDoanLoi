// xấu nhất : O(n^2) (khi pivot là max or min của mảng , mảng đã được sắp xếp)
// tốt nhất và trung bình : 0(nlogn)

package Week6_QuickSort.LyThuyet;

import java.util.Arrays;

public class QuickSort {

    static int partition(int[] arr, int left , int right){

        int pivot = arr[right];

        // i: đánh dấu vị trí cuối cùng của vùng chứa các phần tử <= pivot.
        int i = (left - 1);

        for(int j = left ; j < right; j++){
            if(arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // đưa pivot về đúng vị trí
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    static void quickSort(int[] arr, int left, int right){
        if(left < right){

            // xác định đúng ví trí pivot khi đã sắp xếp
            int p1 = partition(arr, left, right);

            quickSort(arr, left, p1 - 1);   // đệ quy bên trái pivot
            quickSort(arr, p1 + 1, right);   // đệ quy bên phải pivot
        }
    }

    public static void main(String[] args) {
        int[] data = {8,7,2,1,0,9,6};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;
        QuickSort.quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
