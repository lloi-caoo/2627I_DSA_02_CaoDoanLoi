// xây dựng bằng 2 stack
// HackerRank : Queue Using Two Stacks

package Week3_Stack_Queue.BT_LapTrinh.Bai3;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUse2Stack<Item> {
    private Stack<Item> stackIn = new Stack<>();
    private Stack<Item> stackOut = new Stack<>();

    public void enqueue(Item item) {
        stackIn.push(item);
    }

    private void checkEmpty() {
        // nếu stackOut rỗng
        if (stackOut.isEmpty()) {
            // pop stackIn và push vào stackOut
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public Item dequeue() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        checkEmpty();
        return stackOut.pop();
    }

    public Item printFirst() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        checkEmpty();
        return stackOut.peek();
    }

    public static void main(String[] args) {
        QueueUse2Stack<Integer> queue = new QueueUse2Stack<>();
        int q = StdIn.readInt();
        for (int i = 0; i < q; i++) {
            int type = StdIn.readInt();

            if (type == 1) {
                int x = StdIn.readInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                StdOut.println(queue.printFirst());
            }
        }
    }
}