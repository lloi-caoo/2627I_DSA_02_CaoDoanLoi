// Use when: Pham vi gia tri nho (k khong qua lon). ( gia tri ptu max trong mảng ko quá lớn : tránh tạo hàm count quá lơn)
// Time: O(n + k), Space: O(n + k).
// Dem truc tiep tan suat tung gia tri.

package Week5_Merge_sort.Cac_loai_Sort;

import java.util.Arrays;

public class CountingSort {

    void countSort(int[] data, int size){

        // mang output
        int[] output = new int[size];

        // tim max trong data
        int max = data[0];
        for(int i = 0; i < size; i++){
            if(data[i] > max){
                max = data[i];
            }
        }

        // mang dem tan suat tich luy
        int[] count = new int[max + 1];

        // tan suat tung gia tri trong data
        for(int i = 0; i < size; i++){
            count[data[i]] ++;
        }

        // tan suat tich luy
        for(int i = 1; i <= max; i++){
            count[i] += count[i-1];
        }

        // sap xep vao output
        for(int i = size - 1; i >= 0; i--){
            output[count[data[i]] - 1] = data[i];
            count[data[i]] --;
        }

        // sap xep trong data
        for(int i = 0; i < size; i++){
            data[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] data  = {4,2,2,8,3,3,1};
        int size = data.length;
        CountingSort cs = new CountingSort();
        cs.countSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
