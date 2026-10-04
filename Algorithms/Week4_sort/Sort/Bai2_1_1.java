package Week4_sort.Sort;

public class Bai2_1_1 {
    public static char[] SelectionSort(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                char tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        s = s.replace(" ", ""); // thay thế " " bằng ""
        char[] result = SelectionSort(s.toCharArray());
        System.out.println(String.valueOf(result));
    }
}