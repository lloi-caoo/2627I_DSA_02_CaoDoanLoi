// 1.3.9 :  Viết một chương trình đọc từ input chuẩn một biểu thức không có các dấu ngoặc mở và in ra biểu thức trung tố tương đương (biểu thức có đủ các dấu ngoặc đóng).

package Week3_Stack_Queue.Algorithms_4th.Bai1_3_9;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class MissingParenthese {
    public static void main(String[] args) {
        Stack<String> stack_ops =  new Stack<>();
        Stack<String> stack_val =  new Stack<>();

        StdOut.println("Nhap bieu thuc thieu ngoac mơ: ");
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();    // coi token là các đơn vi được ngăn cach nhau = whitespace
            if(s.equals(")")){
                String op = stack_ops.pop();
                String val2 = stack_val.pop();
                String val1 = stack_val.pop();
                String sub = "( " + val1 + " " + op + " "+ val2 + " )";
                stack_val.push(sub);
            }
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                stack_ops.push(s);
            }else{
                stack_val.push(s);
            }
        }
        StdOut.println("Biểu thức hoàn chỉnh: ");
        StdOut.println(stack_val.pop());
    }
}
