package Week3_Stack_Queue.BT_LapTrinh.Bai2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class BalancedBrackets{
    public static String check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if (c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{') {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        StdOut.print("Nhập  chuỗi cần  kiểm tra :");
        if(!StdIn.isEmpty()){
            // đoc tung từ 1 trong chuỗi
            String s = StdIn.readString();
            String res = check(s);
            StdOut.println("Ket qua : " + res);
        }
    }
}
