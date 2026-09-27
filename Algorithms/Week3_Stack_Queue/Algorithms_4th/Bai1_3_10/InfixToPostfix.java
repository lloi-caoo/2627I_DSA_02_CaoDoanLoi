package Week3_Stack_Queue.Algorithms_4th.Bai1_3_10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class InfixToPostfix {
    private static int Uutien(char c){
        switch (c){
            case'+':
            case'-':
                return 1;
            case'*':
            case'/':
                return 2;
            default:
                return -1;
        }
    }
    public static String Postfix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);
            if(c == ' ') continue;   // continue space
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && Uutien(c) <= Uutien(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();

    }

    public static void main(String[] args) {
        StdOut.println("Nhap bieu thuc trung to : ");
        String sb = StdIn.readString();
        System.out.println(Postfix(sb));
    }
}
