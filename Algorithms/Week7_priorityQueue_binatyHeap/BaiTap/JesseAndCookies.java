// ý tuong: tạo 1 priorityqueue sắp xếp tăng dần , lấy m1 , m2 = cách poll Pqueue rồi add vào lại cho đến khi thõa mạn

package Week7_priorityQueue_binatyHeap.BaiTap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class JesseAndCookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> minPqueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            minPqueue.add(sc.nextInt());
        }
        int count = 0;
        while(minPqueue.peek() < K && minPqueue.size() >= 2 && !minPqueue.isEmpty()){
            int m1 = minPqueue.poll();
            int m2 = minPqueue.poll();
            minPqueue.add(m1 + 2*m2);
            count ++;
        }

        if(!minPqueue.isEmpty() && minPqueue.peek() >= K){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
        sc.close();
    }
}
