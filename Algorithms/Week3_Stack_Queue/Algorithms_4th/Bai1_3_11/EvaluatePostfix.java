// đọc một biểu thức hậu tố từ input chuẩn, tính giá trị biểu thức, và in ra.

package Week3_Stack_Queue.Algorithms_4th.Bai1_3_11;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                if(stack.size() < 2) throw new NoSuchElementException("Stack underflow");
                double s2 = stack.pop();
                double s1 = stack.pop();
                double result;

                if (s.equals("+"))
                    result = s1 + s2;
                else if (s.equals("-"))
                    result = s1 - s2;
                else if (s.equals("*"))
                    result = s1 * s2;
                else
                    result = s1 / s2;

                stack.push(result);
            }else{
                stack.push(Double.parseDouble(s));
            }
        }
        System.out.println(stack.pop());

    }
}
