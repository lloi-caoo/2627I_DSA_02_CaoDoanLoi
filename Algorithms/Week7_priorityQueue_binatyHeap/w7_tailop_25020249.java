package Week7_priorityQueue_binatyHeap;

import java.util.*;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class w7_tailop_25020249 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            // 1. Thêm số mới vào maxPQ
            maxPQ.add(num);

            // 2. Chuyển phần tử lớn nhất của maxPQ sang minPQ để duy trì thứ tự
            minPQ.add(maxPQ.poll());

            // 3. Cân bằng kích thước: maxPQ luôn giữ số lượng phần tử bằng hoặc nhiều hơn minPQ 1 phần tử
            if (maxPQ.size() < minPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // 4. In ra giá trị trung vị
            if (maxPQ.size() > minPQ.size()) {
                // Số lượng phần tử là lẻ
                System.out.printf("%.1f\n", (double) maxPQ.peek());
            } else {
                // Số lượng phần tử là chẵn
                double median = (maxPQ.peek() + minPQ.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            }
        }

        scanner.close();
    }
}
