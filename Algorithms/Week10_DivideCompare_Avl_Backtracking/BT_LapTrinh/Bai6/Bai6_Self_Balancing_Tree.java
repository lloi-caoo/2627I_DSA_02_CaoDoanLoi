package Week10_DivideCompare_Avl_Backtracking.BT_LapTrinh.Bai6;

import java.util.Scanner;

class Node {
    int val;
    int ht;
    Node left;
    Node right;

    /*
    Class node is defined as:
    class Node
        int val;    //Value
        int ht;     //Height
        Node left;  //Left child
        Node right; //Right child
    */

    // Hàm hỗ trợ lấy chiều cao của node (Null node có chiều cao -1 theo đề bài)
    static int height(Node n) {
        return n == null ? -1 : n.ht;
    }

    // Hàm xoay phải (Right Rotation)
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Hàm xoay trái (Left Rotation)
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Hàm chèn node AVL chính
    static Node insert(Node root, int val) {
        // 1. Chèn node theo cơ chế của cây nhị phân tìm kiếm
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0; // Node lá có chiều cao là 0
            node.left = null;
            node.right = null;
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root; // Không cho phép giá trị trùng lặp
        }

        // 2. Cập nhật chiều cao của node hiện tại
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        // 3. Tính hệ số cân bằng
        int balance = height(root.left) - height(root.right);

        // 4. Kiểm tra 4 trường hợp mất cân bằng và thực hiện xoay

        // Trường hợp Trái - Trái (Left Left Case)
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // Trường hợp Phải - Phải (Right Right Case)
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // Trường hợp Trái - Phải (Left Right Case)
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Trường hợp Phải - Trái (Right Left Case)
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Cây vẫn cân bằng, trả về node hiện tại
        return root;
    }

    // Duyệt cây theo thứ tự Inorder
    static void inorder(Node T) {
        if (T != null) {
            inorder(T.left);
            System.out.print(T.val + "(BF=" +
                    (height(T.left) - height(T.right)) + ") ");
            inorder(T.right);
        }
    }

    // Duyệt cây theo thứ tự Preorder
    static void preorder(Node T) {
        if (T != null) {
            System.out.print(T.val + "(BF=" +
                    (height(T.left) - height(T.right)) + ") ");
            preorder(T.left);
            preorder(T.right);
        }
    }
}

public class Bai6_Self_Balancing_Tree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            root = Node.insert(root, val);
        }

        int nv = in.nextInt();
        root = Node.insert(root, nv);

        Node.inorder(root);
        System.out.println();

        Node.preorder(root);
        System.out.println();

        in.close();
    }
}

