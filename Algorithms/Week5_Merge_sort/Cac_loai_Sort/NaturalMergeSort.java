// ƯU ĐIỂM so với merge sort thông thường là tận dụng các run đã sắp xếp sẵn
// Best: O(n) khi mảng đã có thứ tự, Average: O(n log n), Worst: O(n log n)

package Week5_Merge_sort.Cac_loai_Sort;


import java.util.Arrays;

public class NaturalMergeSort {

    public static void naturalMergeSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;

        int[] aux = new int[n];

        while (true) {
            int i = 0;
            int runs = 0;

            // Duyệt mảng, tìm các run và trộn từng cặp
            while (i < n) {
                runs++;

                // Tìm cuối run thứ nhất
                int mid = i;
                while (mid + 1 < n && a[mid] <= a[mid + 1]) {
                    mid++;
                }

                // Không còn run thứ hai để trộn
                if (mid == n - 1) {
                    break;
                }

                // Tìm cuối run thứ hai
                int right = mid + 1;
                while (right + 1 < n && a[right] <= a[right + 1]) {
                    right++;
                }

                // Trộn hai run
                merge(a, aux, i, mid, right);

                // Tiếp tục sau run thứ hai
                i = right + 1;
            }

            // Nếu chỉ có một run thì mảng đã được sắp xếp
            if (runs == 1) {
                return;
            }
        }
    }

    private static void merge(
            int[] a, int[] aux, int left, int mid, int right) {

        // Sao chép đoạn cần trộn sang mảng phụ
        for (int k = left; k <= right; k++) {
            aux[k] = a[k];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // Trộn hai run theo thứ tự tăng dần
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }

        while (i <= mid) {
            a[k++] = aux[i++];
        }

        while (j <= right) {
            a[k++] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 8, 1, 3, 7, 4, 6};
        naturalMergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
