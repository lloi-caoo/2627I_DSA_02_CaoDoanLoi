package Week9_BST.BT_Lap_Trinh.HackerRank;

import java.util.Scanner;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        if(data > root.data){
            root.right = insert(root.right , data);
        }
        else{
            root.left = insert(root.left, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        Node root = null;
        while(t-- > 0){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        preOrder(root);
    }

}
