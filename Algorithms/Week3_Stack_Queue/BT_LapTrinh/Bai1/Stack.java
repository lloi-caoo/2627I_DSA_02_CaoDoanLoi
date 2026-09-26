package Week3_Stack_Queue.BT_LapTrinh.Bai1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Stack<Item> {
    private Node first;
    private int n;

    public class Node{
        Item item;
        Node next;
    }

    public Stack(){
        first = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return n;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                stack.push(item);
            }else if(!stack.isEmpty()){
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack");
    }

}
