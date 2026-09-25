package Week3_Stack_Queue;

import java.util.Stack;
// Sử dụng ngăn xếp để cài đặt bài toán biến đổi biểu thức toán học với các phép toán +, - , *, / từ dạng trung tố sang dạng hậu tố (Biểu thức Ba Lan ngược)

public class w3_tailop_25020249 {
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
        String ex = "20-(5+2)*1*3-2*(3+1)";
        System.out.println(Postfix(ex));
    }

}
