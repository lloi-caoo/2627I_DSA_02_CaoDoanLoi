package Week9_BST.BT_Lap_Trinh.HackerRank.Bai5;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Bai5 {
    ArrayList<Integer> values = new ArrayList<>();
    int count = 0;

    void inOrder(Node root, int levels) {
        if (root != null) {
            // Dựng nhánh con bên trái nếu chưa chạm đáy
            if (levels > 0) {
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            // Gán dữ liệu cho nút hiện tại
            root.data = values.get(count);
            count++;

            // Dựng nhánh con bên phải nếu chưa chạm đáy
            if (levels > 0) {
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }


    boolean checkBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Hàm phụ trợ kiểm tra khoảng giá trị hợp lệ (min < node.data < max)
    private boolean isValidBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        // Giá trị nút phải lớn hơn min và nhỏ hơn max (không được bằng nhau)
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Nhánh trái phải nhỏ hơn nút hiện tại, nhánh phải phải lớn hơn nút hiện tại
        return isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int height = scanner.nextInt();

        Bai5 tree = new Bai5();
        while (scanner.hasNextInt()) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();

        // Dựng cây từ mảng values
        Node root = new Node();
        tree.inOrder(root, height);

        // Kiểm tra và in kết quả
        System.out.println(tree.checkBST(root) ? "Yes" : "No");
    }
}