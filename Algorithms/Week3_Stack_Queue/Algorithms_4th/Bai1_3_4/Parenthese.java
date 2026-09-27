// 1.3.4

package Week3_Stack_Queue.Algorithms_4th.Bai1_3_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Parenthese {
    public static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if (c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println("Nhap chuoi can kiem tra : ");
        if(!StdIn.isEmpty()){
            String s = StdIn.readString();   // StdIn.readString : đọc từng token (là đơn vị dữ liệu được tách ra bởi whitespace)
            boolean res = check(s);
            StdOut.println("Ket qua : " + res);
        }
    }
}
