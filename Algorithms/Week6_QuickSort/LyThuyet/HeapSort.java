// Best: O(n log n), Average: O(n log n), Worst: O(n log n)

package Week6_QuickSort.LyThuyet;

public class HeapSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // Bước 1: Xây dựng Max Heap từ dưới lên.
        // Các node từ n/2 đến n-1 là node lá nên ko có các con để so sánh.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Bước 2: Đưa phần tử lớn nhất về cuối mảng.
        for (int i = n - 1; i > 0; i--) {

            // Đổi chỗ root (lớn nhất) với phần tử cuối
            // của vùng Heap chưa sắp xếp.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Khôi phục Max Heap trong arr[0..i-1].
            heapify(arr, i, 0);
        }
    }

    // Khôi phục tính chất Max Heap tại node i.
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // Chỉ số con trái
        int r = 2 * i + 2; // Chỉ số con phải

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // Nếu node i chưa lớn nhất, đổi chỗ với node lớn nhất.
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Tiếp tục khôi phục Max_Heap ở nhánh vừa bị thay đổi.
            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 9, 5, 6, 10};

        HeapSort hp = new HeapSort();
        hp.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
