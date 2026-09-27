package Week3_Stack_Queue.BT_LapTrinh.Bai5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        // duyet ngược sao cho ptu đầu ở đỉnh
        for (int i = h1.size() - 1; i >= 0; i--) {
            st1.push(h1.get(i));
            sum1 += h1.get(i);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            st2.push(h2.get(i));
            sum2 += h2.get(i);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            st3.push(h3.get(i));
            sum3 += h3.get(i);
        }

        // tim dia cao nhat và pop
        while (!(sum1 == sum2 && sum2 == sum3)) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= st1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= st2.pop();
            } else {
                sum3 -= st3.pop();
            }
        }
        return sum1;
    }

    public static void main(String[] args) {
        // Đọc số lượng phần tử của 3 mảng
        int n1 = StdIn.readInt();
        int n2 = StdIn.readInt();
        int n3 = StdIn.readInt();

        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            h1.add(StdIn.readInt());
        }

        for (int i = 0; i < n2; i++) {
            h2.add(StdIn.readInt());
        }

        for (int i = 0; i < n3; i++) {
            h3.add(StdIn.readInt());
        }

        int result = equalStacks(h1, h2, h3);
        StdOut.println(result);
    }
}