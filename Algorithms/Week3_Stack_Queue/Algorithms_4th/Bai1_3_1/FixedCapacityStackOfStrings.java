// 1.3.1

package Week3_Stack_Queue.Algorithms_4th.Bai1_3_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;
    private int n;
    public FixedCapacityStackOfStrings(int capacity){
        a = new String[capacity];
        n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public boolean isFull(){
        return n == a.length;
    }
    public void push(String item){
        a[n++] = item;   // dùng n rồi mới tăng n sau
    }
    public String pop(){
        return a[--n];   // giảm n rồi mới dùng
    }
    public String peek(){
        return a[n - 1];
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<String> {
        private int i = n-1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.println(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.print("Let on the stack");
        for(String s : stack){
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
