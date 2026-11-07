package Week9_BST.BT_Lap_Trinh.HackerRank;

import java.util.Scanner;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class LowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        if(root == null){
            return null;
        }
        if(v1 <= root.data && v2 >= root.data){
            return root;
        }
        else if(v1 >= root.data){
            return lca(root.right, v1 , v2);
        }else{
            return lca(root.left, v1 , v2);
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        else{
            if(data >= root.data){
                root.right = insert(root.right, data);
            }else{
                root.left = insert(root.left, data);
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        Node root = null;
        while(t-- > 0){
            int data = sc.nextInt();
            root =  insert(root, data);
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        // quy uoc v2 max , v1 min
        if(v1 >= v2){
            int temp = v2;
            v2 = v1;
            v1 = temp;
        }
        sc.close();
        Node ans = lca(root, v1 , v2);

        if(ans != null) {System.out.println(ans.data);}
    }
}
