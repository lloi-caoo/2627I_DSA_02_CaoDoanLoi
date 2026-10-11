// Best: phụ thuộc dãy gap, thường O(n log n), Average/Worst: phụ thuộc dãy gap

package Week5_Merge_sort.Cac_loai_Sort;

import java.util.Arrays;

public class ShellSort {

    void shellSort(int[] arr, int n) {
        // Giảm dần khoảng cách giữa các phần tử được so sánh
        for (int interval = n / 2; interval > 0; interval /= 2) {

            // Duyệt các phần tử để chèn vào đúng vị trí trong nhóm
            for (int i = interval; i < n; i++) {

                // Lưu phần tử cần chèn
                int temp = arr[i];
                int j;

                // Dịch các phần tử lớn hơn temp sang phải
                for (j = i;
                     j >= interval && arr[j - interval] > temp;
                     j -= interval) {

                    arr[j] = arr[j - interval];
                }

                // Chèn temp vào vị trí thích hợp
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {9, 8, 3, 7, 5, 6, 4, 1};
        int size = data.length;

        ShellSort ss = new ShellSort();
        ss.shellSort(data, size);

        System.out.println("Sorted Array in Ascending Order:");
        // System.out.println(data); // chỉ in ra biễu diễn mặc định của đối tưởng mảng : [I@2f92e0f4
        System.out.println(Arrays.toString(data));
    }
}
