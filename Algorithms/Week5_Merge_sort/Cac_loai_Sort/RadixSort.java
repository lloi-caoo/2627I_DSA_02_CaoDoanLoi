// Use when: Pham vi gia tri lon nhung so chu so it/co gioi han. ( mảng có ptu max lớn nhưng số ptu mảng it)
// Time: O(d * (n + b)), Space: O(n + b).
// Sap xep theo tung chu so bang Counting Sort on dinh.

package Week5_Merge_sort.Cac_loai_Sort;

import java.util.Arrays;

public class RadixSort {

    // Sắp xếp ổn định theo từng chữ số, từ hàng đơn vị đến hàng cao nhất
    public static void countingSort(int[] arr, int place){
        int size = arr.length;
        int[] output = new int[size];
        int[] count = new int[10];  // 0 -> 9


        for(int i = 0; i < size; i++){
            // Lay chu so tai hang place (don vi, chuc, tram,...)
            int index = (arr[i]/place)%10;
            count[index] ++;
        }

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        // Duyet nguoc de dat phan tu vao output, dam bao tinh on dinh
        for(int i = size - 1; i >= 0; i--){
            int index = (arr[i] / place)%10;
            output[count[index] - 1] = arr[i];
            count[index] --;
        }

        for(int i = 0; i < size ; i++){
            arr[i] = output[i];
        }
    }

    // Lần lượt sắp xếp theo từng hàng chữ số
    public static void radixSort(int[] arr){
        int maxElement = getMax(arr);

        System.out.println("Trạng thái mảng sau mỗi lượt sắp xếp theo chữ số :");

        for(int place = 1; maxElement/ place > 0; place *= 10){
            countingSort(arr, place);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {121, 432, 564, 23, 1 ,45, 788};
        radixSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
