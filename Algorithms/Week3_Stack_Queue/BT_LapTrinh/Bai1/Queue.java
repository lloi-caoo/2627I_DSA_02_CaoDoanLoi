package Week3_Stack_Queue.BT_LapTrinh.Bai1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Queue<Item>{
    private Node first;
    private Node last;
    private int n;

    private class Node{
        Item item;   // mặc định Node.item = null
        Node next;   // mặc định mới khởi tạo Node.next = null
    }
    public Queue(){
        first = null;
        last = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) first = last;
        else {
            oldlast.next = last;
        }
        n++;
    }
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");  // chặn lỗi và dừng hàm
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;  // nếu sau khi xóa null thì queue rỗng
        return item;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                queue.enqueue(item);
            }else if(!queue.isEmpty()){
                StdOut.print(queue.dequeue() + " ");
            }
        }
        StdOut.println("(" + queue.size() + " left on queue");
    }

}
