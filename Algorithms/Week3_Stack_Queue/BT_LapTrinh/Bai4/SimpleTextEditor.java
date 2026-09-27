// HackerRank : Simple Text Editor

package Week3_Stack_Queue.BT_LapTrinh.Bai4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class SimpleTextEditor {
    private StringBuilder text = new StringBuilder();
    private Stack<String> stack_history = new Stack<>();
    public void append(String w){
        stack_history.push("2 " + w.length());
        text.append(w);
    }
    public void delete(int k){
        String sub = text.substring(text.length() - k);
        stack_history.push("1 " + sub);
        text.delete(text.length() - k, text.length());

    }
    public char print(int k){
        return text.charAt(k - 1);
    }
    public void undo(){
        if(stack_history.isEmpty()) return;
        String command = stack_history.pop();
        String[] word = command.split(" ");
        if(word[0].equals("1")){
            text.append(word[1]);
        }else if(word[0].equals("2")){
            text.delete(text.length() - Integer.parseInt(word[1]),text.length());
        }
    }

    public static void main(String[] args) {
        SimpleTextEditor simple = new SimpleTextEditor();
        int q = StdIn.readInt();
        for(int i = 0; i < q; i++){
            int type = StdIn.readInt();

            if (type == 1) {
                String x = StdIn.readString();
                simple.append(x);
            } else if (type == 2) {
                simple.delete(StdIn.readInt());
            } else if (type == 3) {
                StdOut.println(simple.print(StdIn.readInt()));
            } else {
                simple.undo();
            }
        }
    }
}
