// Thay đổi insertionSort thành mergeSort từ Bài INSERTIONSORT PART I (hacker rank)

// Nhận xét: Với dữ liệu 2 4 6 8 3, Insertion Sort chỉ cần chèn 3 vào đoạn đã được sắp xếp nên có độ phức tạp O(N). Merge Sort phải chia và merge toàn bộ mảng, có độ phức tạp O(N log N).
// Kết luận: Với bài toán này, Insertion Sort phù hợp hơn vì tận dụng được dữ liệu đã gần sắp xếp.

package Week5_Merge_sort.BT_LapTrinh.Bai2;

public class MergeSort {
    public void merge(int[] arr , int l , int m ,int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] M = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(int i = 0; i < n2; i++){
            M[i] = arr[m + 1 + i];
        }

        int i,j,k;
        i = 0;
        j = 0;
        k = l;

        while(i < n1 && j < n2){
            if(L[i] <= M[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = M[j];
                j++;
            }k++;
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = M[j];
            j++;
            k++;
        }
    }
    void mergeSort(int[] arr ,int l ,int r){
        if(l < r){
            int m = l + (r - l)/2;
            mergeSort(arr, l , m);
            mergeSort(arr,m + 1, r);
            merge(arr, l ,m , r);

            printALlArray(arr);
        }
    }
    public static void printALlArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 3};
        MergeSort meg = new MergeSort();
        meg.mergeSort(arr, 0, arr.length - 1);

    }
}

