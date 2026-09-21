package Week2_AnalysisOfAlgorithms.Bai_tap.Bai1_4_20;
public class FibonacciSearch {
    public static int search(int [] arr, int target){
        int n = arr.length;
        if(n == 0) return -1;

        int fib2 = 0;
        int fib1 = 1;
        int fibN = fib2 + fib1;

        // tim so fibN min >= n
        while(fibN < n){
            fib2 = fib1;
            fib1 = fibN;
            fibN = fib2 + fib1;
        }
        // vi tri bat dau loai bo
        int offset = -1;
        // quy trinh chinh
        while(fibN > 1){
            int i = offset + fib2;   // xet vi tri cua fb2
            if(i >= n - 1){
                i = n - 1;
            }
            if(target > arr[i]){
                fibN = fib2;
                fib1 = fib1 - fib2;
                fib2 = fibN - fib1;
            }else if(target < arr[i]){
                fibN = fib1;
                fib1 = fib2;
                fib2 = fibN - fib1;
                offset = i;
            }
            else{
                return i;
            }
        }
        // truong hop con lai
        if (fib1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {99, 85, 72, 60, 45, 30, 25, 10, 5, 2};
        int target = 45;

        int result = search(arr, target);
        System.out.println("Vị trí của " + target + " là: " + result);
    }
}